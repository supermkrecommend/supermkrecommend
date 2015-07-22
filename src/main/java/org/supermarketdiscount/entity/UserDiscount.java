package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.UserDiscountMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public class UserDiscount implements Serializable {
    private long userid;
    private long commodityid;
    private Long typeid;
    private Double promotionPrice;
    private Integer promotionstandard;
    private Date nextpruchasetime;
    private Double totalcount;
    private Double consumeday;
    private Double salseCount;

    public void save() {
        ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).add(this);
    }

    public void del() {
        ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).del(this);
    }
    public void delByuserid(){
        if(this.getUserid() == null){
            throw new NullPointerException();
        }
        ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).del(this);
    }

    public void delByCommodityid(){
        if(this.getCommodityid() == null){
            throw new NullPointerException();
        }
        ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).del(this);
    }
    public void update() {
        ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).update(this);
    }

    public void changeStandard(DiscountStandard standard) {
        this.setPromotionstandard(standard.getPromotionstandard());
        this.setPromotionPrice(standard.getSalse());
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Long commodityid) {
        this.commodityid = commodityid;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public Double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getPromotionstandard() {
        return promotionstandard;
    }

    public void setPromotionstandard(Integer promotionstandard) {
        this.promotionstandard = promotionstandard;
    }

    public Date getNextpruchasetime() {
        return nextpruchasetime;
    }

    public void setNextpruchasetime(Date nextpruchasetime) {
        this.nextpruchasetime = nextpruchasetime;
    }

    public Double getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Double totalcount) {
        this.totalcount = totalcount;
    }

    public Double getConsumeday() {
        return consumeday;
    }

    public void setConsumeday(Double consumeday) {
        this.consumeday = consumeday;
    }

    public Double getSalseCount() {
        return salseCount;
    }

    public void setSalseCount(Double salseCount) {
        this.salseCount = salseCount;
    }

    @Override
    public String toString() {
        return "userDiscount{" +
                "userid=" + userid +
                ", commodityid=" + commodityid +
                ", typeid=" + typeid +
                ", promotionPrice=" + promotionPrice +
                ", promotionstandard=" + promotionstandard +
                ", salseCount=" + salseCount +
                '}';
    }
}
