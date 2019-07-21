import com.fasterxml.jackson.databind.ObjectMapper;
import com.hisign.entity.PassPersonEntity;
import com.hisign.entity.UserProducts;
import com.hisign.repository.PassPersonRepository;
import com.hisign.utils.CommonUtils;
import com.hisign.vo.StatVO;
import com.hisign.vo.UserProdAggVO;
import com.mongodb.WriteResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * mongoDB 官方文档请参考：https://docs.mongodb.com/v3.4/
 * mongo java driver 文档：请参考：http://mongodb.github.io/mongo-java-driver/3.4/
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mongo.xml"})
public class TestSpringDataMongo {


    @Autowired
    private MongoOperations mongoTemplate;

    @Autowired
    private PassPersonRepository passPersonRepository;

    private static final ObjectMapper om = new ObjectMapper();

    /**
     * 测试查询全表
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        List<PassPersonEntity> list = mongoTemplate.findAll(PassPersonEntity.class, "passPerson1");
        for(PassPersonEntity entity:list){
            System.out.println(om.writeValueAsString(entity));
        }
    }

    /**
     * 测试将ObjectId 转化成字符串（24位uuid)
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        List<PassPersonEntity> list = mongoTemplate.findAll(PassPersonEntity.class, "passPerson1");
        for(PassPersonEntity entity:list){
            System.out.println(om.writeValueAsString(entity));
        }
    }

    /**
     * 测试根据id查询
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        Criteria criteria = Criteria.where("_id").is("58f87c7c047ea42e53509724");
        Query query = Query.query(criteria);
//        PassPersonEntity entity = mongoTemplate.findById(new ObjectId("58f87c7c047ea42e53509724"),PassPersonEntity.class,"passPerson1");
        PassPersonEntity entity = mongoTemplate.findOne(query,PassPersonEntity.class,"passPerson1");
        System.out.println(om.writeValueAsString(entity));
    }


    /**
     * 测试分页查询
     * @throws Exception
     */
    @Test
    public void test4() throws Exception{
        Criteria criteria = Criteria.where("");
        PageRequest page = new PageRequest(1,10);//第一页、每页10条
        Query query = Query.query(criteria).with(page).with(new Sort(Sort.Direction.DESC,"passTime"));
        List<PassPersonEntity> list = mongoTemplate.find(query, PassPersonEntity.class, "passPerson1");
        for(PassPersonEntity entity:list){
            System.out.println(om.writeValueAsString(entity));
        }
    }


    /**
     * 测试聚合
     * @throws Exception
     */
    @Test
    public void test5() throws Exception{

        /**
         db.passPerson1.aggregate(
            {$match:
                {
                    passTime:{$gte:ISODate("2016-12-31T16:00:00"),$lte:ISODate("2017-12-31T16:00:00")}
                }
            },
            {$group:
                {
                    _id:{stationNo:"$stationNo"},
                    total:{$sum:1}
                }
            }
         )

         */


        Date startDate = CommonUtils.strToDate("yyyy-MM-dd", "2017-01-01");
        Date endDate = CommonUtils.strToDate("yyyy-MM-dd", "2017-12-31");
        Criteria criteria = Criteria.where("passTime").gte(startDate).lte(endDate);


        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria),
                Aggregation.group("stationNo").count().as("total"),
                /*以下这种写法可以将分组以后的重命名为stationNo*/
                Aggregation.project("stationNo","total").and("stationNo").previousOperation()
        );

        AggregationResults<StatVO> result = mongoTemplate.aggregate(aggregation, "passPerson1", StatVO.class);


        List<StatVO> mappedResults = result.getMappedResults();

        for(StatVO vo:mappedResults){
            System.out.println(vo.getStationNo()+"===="+vo.getTotal());
        }

    }


//    /**
//     * 测试聚合
//     * @throws Exception
//     */
//    @Test
//    public void test14() throws Exception{
//
//        Criteria criteria = Criteria.where("");
//        criteria.and("organizationCode").regex("^65");
//        criteria.and("stationType").is("4");//20171010新需求首页数据中统计检查站。
//
//        TypedAggregation<PersonBlacklistAlarm> agg = Aggregation.newAggregation(
//                PersonBlacklistAlarm.class,
//                Aggregation.match(criteria),
//                Aggregation.project().and("passTime").minus(-8*60*60*1000).as("UTCTime"),
//                Aggregation.project().and("UTCTime").extractHour().as("hour"),
//                Aggregation.group("hour").count().as("y"),
//                Aggregation.project("hour", "y").and("x").previousOperation()
//        );
//
//        AggregationResults<StatCoordinateDto> result = mongoTemplate.aggregate(agg, StatCoordinateDto.class);
//
//    }



    /**
     * 测试插入一条数据
     * @throws Exception
     */
    @Test
    public void test6() throws Exception{
        Criteria criteria = Criteria.where("_id").is("58f87c7c047ea42e53509724");
        Query query = Query.query(criteria);
//        PassPersonEntity entity = mongoTemplate.findById(new ObjectId("58f87c7c047ea42e53509724"),PassPersonEntity.class,"passPerson1");
        PassPersonEntity entity = mongoTemplate.findOne(query,PassPersonEntity.class,"passPerson1");
        PassPersonEntity newObj = new PassPersonEntity();
        BeanUtils.copyProperties(entity,newObj,"id");
        mongoTemplate.insert(newObj,"testTable");
    }


    /**
     * 测试插入多条数据
     * @throws Exception
     */
    @Test
    public void test7() throws Exception{
        Criteria criteria = Criteria.where("_id").is("58f87c7c047ea42e53509724");
        Query query = Query.query(criteria);
//        PassPersonEntity entity = mongoTemplate.findById(new ObjectId("58f87c7c047ea42e53509724"),PassPersonEntity.class,"passPerson1");
        PassPersonEntity entity = mongoTemplate.findOne(query,PassPersonEntity.class,"passPerson1");
        List<PassPersonEntity> list = new ArrayList<>();
        PassPersonEntity newObj = new PassPersonEntity();
        BeanUtils.copyProperties(entity,newObj,"id");
        list.add(newObj);
        list.add(newObj);
        list.add(newObj);
        list.add(newObj);
        list.add(newObj);
        mongoTemplate.insert(list,"testTable");
    }

    /**
     * 测试删除一条数据
     * @throws Exception
     */
    @Test
    public void test8() throws Exception{
        Criteria criteria = Criteria.where("_id").is("5aab1b1108c442516fe0eca5");
        Query query = Query.query(criteria);
        WriteResult testTable = mongoTemplate.remove(query, "testTable");
        System.out.println(testTable.toString());
    }

    /**
     * 测试查找并删除 findAndRemove (只删除一个）
     * @throws Exception
     */
    @Test
    public void test9() throws Exception{
        Criteria criteria = Criteria.where("name").is("李亚");
        Query query = Query.query(criteria);

        PassPersonEntity testTable = mongoTemplate.findAndRemove(query, PassPersonEntity.class, "testTable");
//        List<PassPersonEntity> testTable1 = mongoTemplate.findAllAndRemove(query, PassPersonEntity.class, "testTable");
        System.out.println(testTable.toString());
    }


    /**
     * 测试查找并删除 findAllAndRemove (符合条件的全部删除）
     * @throws Exception
     */
    @Test
    public void test10() throws Exception{
        Criteria criteria = Criteria.where("name").is("李亚");
        Query query = Query.query(criteria);
        List<PassPersonEntity> testTable = mongoTemplate.findAllAndRemove(query, PassPersonEntity.class, "testTable");
        System.out.println(testTable.toString());
    }


    /**
     * 测试查找并更新 updateFirst (符合条件的全部删除）
     * @throws Exception
     */
    @Test
    public void test11() throws Exception{
        Criteria criteria = Criteria.where("name").is("李亚");
        Query query = Query.query(criteria);
        Update update = Update.update("name","李亚1");
        WriteResult testTable = mongoTemplate.updateFirst(query, update, "testTable");
        System.out.println(testTable.toString());
    }


    /**
     * 测试查找并更新 updateMulti (符合条件的全部删除）
     * @throws Exception
     */
    @Test
    public void test12() throws Exception{
        Criteria criteria = Criteria.where("name").is("李亚");
        Query query = Query.query(criteria);
        Update update = Update.update("name","李亚1");
        WriteResult testTable = mongoTemplate.updateMulti(query, update, "testTable");
        System.out.println(testTable.toString());
    }


    /**
     * 测试查找并更新 findAndModify (只更新一个）= updateFirst
     * @throws Exception
     */
    @Test
    public void test13() throws Exception{
        Criteria criteria = Criteria.where("name").is("李亚1");
        Query query = Query.query(criteria);
        Update update = Update.update("name","李亚2");
        PassPersonEntity testTable = mongoTemplate.findAndModify(query, update, PassPersonEntity.class, "testTable");
        System.out.println(testTable.toString());

    }


    @Test
    public void testAggregation(){
        try {
//            Aggregation aggregation = Aggregation.newAggregation(Aggregation.group("userId").sum("prods").as("total"));
            Aggregation aggregation = Aggregation.newAggregation(Aggregation.group("userId").sum("prods.001").as("total"));

            AggregationResults<UserProdAggVO> aggregate = mongoTemplate.aggregate(aggregation, UserProducts.class, UserProdAggVO.class);

            List<UserProdAggVO> mappedResults = aggregate.getMappedResults();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public void testAggregation1(){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.group("userId").count().as("total"));
        AggregationResults<Map> aggregate = mongoTemplate.aggregate(aggregation, UserProducts.class, Map.class);
        aggregate.forEach(x-> System.out.println(x));
    }

    @Test
    public void testFindAll(){
        List<UserProducts> all = mongoTemplate.findAll(UserProducts.class);
        all.forEach(x-> System.out.println(x));
    }










}
