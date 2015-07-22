package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.PromotionPriceMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/24.
 */
public class PromotionPrice implements Serializable {
    private long promotionid;
    private long commodityid;
    private Double salse;
    private Date salseStartDate;
    private Date salseEndDate;

    public void save() {
        ((PromotionPriceMapper) SpringContextUtil.getBean("promotionPriceMapper")).add(this);
    }

    public void del() {
        ((PromotionPriceMapper) SpringContextUtil.getBean("promotionPriceMapper")).del(this);
    }

    public void delByCommodityid() {
        ((PromotionPriceMapper) SpringContextUtil.getBean("promotionPriceMapper")).delByCommodityid(this);
    }

    public void update() {
        ((PromotionPriceMapper) SpringContextUtil.getBean("promotionPriceMapper")).update(this);
    }

    public long getPromotionid() {
        return promotionid;
    }

    public void setPromotionid(long promotionid) {
        this.promotionid = promotionid;
    }

    public long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(long commodityid) {
        this.commodityid = commodityid;
    }

    public Double getSalse() {
        return salse;
    }

    public void setSalse(double salse) {
        this.salse = salse;
    }

    public Date getSalseStartDate() {
        return salseStartDate;
    }

    public void setSalseStartDate(Date salseStartDate) {
        this.salseStartDate = salseStartDate;
    }

    public Date getSalseEndDate() {
        return salseEndDate;
    }

    public void setSalseEndDate(Date salseEndDate) {
        this.salseEndDate = salseEndDate;
    }

    @Override
    public String toString() {
        return "promotionPrice{" +
                "promotionid=" + promotionid +
                ", commodityid=" + commodityid +
                ", salse=" + salse +
                ", salseStartDate=" + salseStartDate +
                ", salseEndDate=" + salseEndDate +
                '}';
    }
}
