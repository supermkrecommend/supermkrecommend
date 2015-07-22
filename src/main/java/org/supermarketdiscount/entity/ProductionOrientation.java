package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.ProductionOrientationMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/24.
 */
public class ProductionOrientation implements Serializable {
    private Integer orientationid;
    private String orientationDescribtion;

    public void save() {
        ((ProductionOrientationMapper) SpringContextUtil.getBean("productionOrientationMapper")).add(this);
    }

    public void del() {
        ((ProductionOrientationMapper) SpringContextUtil.getBean("productionOrientationMapper")).del(this);
    }

    public void update() {
        ((ProductionOrientationMapper) SpringContextUtil.getBean("productionOrientationMapper")).update(this);
    }

    @Override
    public String toString() {
        return "ProductionOrientation{" +
                "orientationid=" + orientationid +
                ", orientationDescribtion='" + orientationDescribtion + '\'' +
                '}';
    }

    public Integer getOrientationid() {
        return orientationid;
    }

    public void setOrientationid(Integer orientationid) {
        this.orientationid = orientationid;
    }

    public String getOrientationDescribtion() {
        return orientationDescribtion;
    }

    public void setOrientationDescribtion(String orientationDescribtion) {
        this.orientationDescribtion = orientationDescribtion;
    }
}
