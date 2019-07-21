import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/3/16.
 */

public class TestMongoJavaDriver {

    public static  MongoClient mongoClient;

    static{
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://192.168.30.192:29017,192.168.30.193:29017,192.168.30.194:29017");
        mongoClient = new MongoClient(mongoClientURI);
    }

    /**
     * 测试 mongo java driver 的聚合，也不很好用，就是没有做orm映射，需要自己用json去接收。
     */
    @Test
    public void test1(){

        MongoDatabase o2m = mongoClient.getDatabase("o2m");

        MongoCollection<Document> collection = o2m.getCollection("dataStatisticOfToday");

        List<String> fields = new ArrayList<>();
        fields.add("personHourStat");
        fields.add("stationType");
        fields.add("organizationCode");
        fields.add("focusPersonHourStat");

        AggregateIterable<Document> aggregate = collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.and(Filters.eq("statisticDate", "20180108"),
                                Filters.regex("organizationCode", "^65"),
                                Filters.eq("stationType", 4))),
                        Aggregates.project(Projections.include(fields)),
                        Aggregates.facet(
                                new Facet("passPersonStat",
                                        Aggregates.unwind("$personHourStat"),
                                        /*知识点1：substr的使用*/
                                        Aggregates.group(new Document("$substr", Arrays.asList("$organizationCode", 0, 6)), Accumulators.sum("count", "$personHourStat.count")),
                                        Aggregates.project(Projections.include("_id", "count"))
                                ),
                                new Facet("focusPersonStat",
                                        Aggregates.unwind("$focusPersonHourStat"),
                                        Aggregates.group(new Document("$substr", Arrays.asList("$organizationCode", 0, 6)), Accumulators.sum("count", "$focusPersonHourStat.count")),
                                        Aggregates.project(Projections.include("_id", "count"))
                                )
                        )

                )
        );
        MongoCursor<Document> iterator = aggregate.iterator();
        while(iterator.hasNext()){
            Document next = iterator.next();
            System.out.println(next.toJson());

        }
    }

    @Test
    public void test2(){

        MongoDatabase o2m = mongoClient.getDatabase("o2m");
        MongoCollection<Document> collection = o2m.getCollection("testTable");
        collection.find(new Document()).forEach(printBlock);
    }


    /**
     * 测试删除
     */
    @Test
    public void delete() {
        MongoCollection<Document> orders = mongoClient.getDatabase("test").getCollection("orders");
    /*删除 ：成功会返回AcknowledgedDeleteResult{deletedCount=1}*/
        DeleteResult id = orders.deleteOne(Filters.eq("_id", new ObjectId("5aab598c88716a129c3c5c5d")));
        System.out.println(id);
    }

    /**
     * 测试更新多个
     */
    @Test
    public void updateMany() {
        MongoCollection<Document> orders = mongoClient.getDatabase("test").getCollection("orders");
        orders.updateMany(Filters.eq("cust_id","A123"),new Document("$set",new Document("amount",3000)));
        orders.find(Filters.eq("cust_id","A123")).forEach(printBlock);
    }

    /**
     * 测试更新一个
     */
    @Test
    public void updateOne() {
        MongoCollection<Document> orders = mongoClient.getDatabase("test").getCollection("orders");
        orders.updateOne(Filters.eq("cust_id","B212"),new Document("$set",new Document("amount",2000)));
        System.out.println(orders.find(Filters.eq("cust_id","B212")).first());
    }

    /**
     * 一次插入一个或者一次插入多个
     */
    @Test
    public void insertOneAndInsertMany() {
        MongoCollection<Document> orders = mongoClient.getDatabase("test").getCollection("orders");
        orders.drop();
//        orders.insertOne(document);
        ArrayList<Document> documents = new ArrayList<Document>(){{
            add(new Document("cust_id","B212").append("amount",1000));
            add(new Document("cust_id","A123").append("amount",1000));
            add(new Document("cust_id","A123").append("amount",1000));
        }};
        orders.insertMany(documents);
    }

    /**
     * 带条件 查询只打印第一个
     */
    @Test
    public void QueryWithFilterAndPrintFirst() {
        MongoCollection<Document> orders = mongoClient.getDatabase("test").getCollection("orders");
        Document myDoc = orders.find(Filters.eq("_id", new ObjectId("5aab58ea88716a2a60031d9f"))).first();
        System.out.println(myDoc.toJson());
    }

    /**
     * 查寻所有并打印
     */
    @Test
    public void queryAllAndPrint() {
        MongoCollection<Document> orders = mongoClient.getDatabase("test").getCollection("orders");
        FindIterable<Document> documents = orders.find();
        documents.forEach(printBlock);
    }


    /**
     * 带条件查询全部打印
     */
    @Test
    public void queryWithFilterAndPrint() {
        MongoCollection<Document> orders = mongoClient.getDatabase("test").getCollection("orders");
        orders.find(Filters.eq("cust_id","A123")).forEach(printBlock);
    }



    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };




}
