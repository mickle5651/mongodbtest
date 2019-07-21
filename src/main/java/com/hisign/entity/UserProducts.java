package com.hisign.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "t_user_prod")
@Data
public class UserProducts {

    private ObjectId id;

    private Integer userId;

    private Map<String,Integer> prods;


}
