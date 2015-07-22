package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.CommodityMarkMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/24.
 */
public class CommodityMark implements Serializable {
    private long markid;
    private String describtion;

    public void save() {
        ((CommodityMarkMapper) SpringContextUtil.getBean("commodityMarkMapper")).add(this);
    }

    public void del() {
        ((CommodityMarkMapper) SpringContextUtil.getBean("commodityMarkMapper")).del(this);
    }

    public void update() {
        ((CommodityMarkMapper) SpringContextUtil.getBean("commodityMarkMapper")).update(this);
    }

    public long getMarkid() {
        return markid;
    }

    public void setMarkid(long markid) {
        this.markid = markid;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    @Override
    public String toString() {
        return "CommodityMark{" +
                "markid=" + markid +
                ", describtion='" + describtion + '\'' +
                '}';
    }
}
