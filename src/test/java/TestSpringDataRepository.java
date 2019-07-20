import com.fasterxml.jackson.databind.ObjectMapper;
import com.hisign.entity.PassPersonEntity;
import com.hisign.repository.PassPersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mongo.xml"})
public class TestSpringDataRepository {

    @Autowired
    private PassPersonRepository passPersonRepository;

    private static final ObjectMapper om = new ObjectMapper();
    /**
     * 测试根据方法名称定义方法
     */
    @Test
    public void test1(){
        List<PassPersonEntity> list = this.passPersonRepository.findByName("李亚");
        System.out.println(list.size());
    }


    /**
     * 测试根据@Query名称定义方法
     */
    @Test
    public void test2() throws Exception{
        List<PassPersonEntity> list = this.passPersonRepository.findByPersonName("李亚");
        for(PassPersonEntity entity:list){
            System.out.println(om.writeValueAsString(entity));
        }
    }

}
