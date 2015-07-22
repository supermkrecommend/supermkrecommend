package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.CommodityTypeMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/24.
 */
public class CommodityType implements Serializable {
    private Integer typeid;
    private String typeName;

    public void save() {
        ((CommodityTypeMapper) SpringContextUtil.getBean("commodityTypeMapper")).add(this);
    }

    public void del() {
        ((CommodityTypeMapper) SpringContextUtil.getBean("commodityTypeMapper")).del(this);
    }

    public void update() {
        ((CommodityTypeMapper) SpringContextUtil.getBean("commodityTypeMapper")).update(this);
    }

    @Override
    public String toString() {
        return "CommodityType{" +
                "typeid=" + typeid +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
