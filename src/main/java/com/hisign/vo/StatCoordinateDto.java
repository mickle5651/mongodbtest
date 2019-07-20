package com.hisign.vo;

import java.io.Serializable;

/**
 * 折线图统计坐标对象
 * Created by zilongLiu on 2016/6/8.
 */
public class StatCoordinateDto implements Serializable{

    private String x;

    private Integer y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "StatCoordinateDto{" +
                "x='" + x + '\'' +
                ", y=" + y +
                '}';
    }

}
