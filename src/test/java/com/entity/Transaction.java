package com.entity;

//@Data
public class Transaction {

    private Integer id;

    public static final String GROCERY = "1";

    private String type;

    private Integer value;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getGROCERY() {
        return GROCERY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
