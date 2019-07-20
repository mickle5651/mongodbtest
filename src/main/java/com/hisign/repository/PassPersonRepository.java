package com.hisign.repository;

import com.hisign.entity.PassPersonEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/3/15.
 */
public interface PassPersonRepository extends CrudRepository<PassPersonEntity,ObjectId>,PassPersonRepositoryCustom{

    /*根据方法名构建query,默认查询全部字段*/
    List<PassPersonEntity> findByName(String Name);

    /*使用@Query构建查询，可指定返回的字段*/
    @Query(value = "{'name':?0}",fields = "{'name':1,'cardNo':1,'stationNo':1}")
    List<PassPersonEntity> findByPersonName(String name);



}
