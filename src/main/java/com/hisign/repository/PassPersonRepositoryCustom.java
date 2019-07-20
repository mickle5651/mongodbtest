package com.hisign.repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/15.
 */
public interface PassPersonRepositoryCustom {

    List<PassPersonRepository> findAll(Map<String,Object> conditionMaps);

}
