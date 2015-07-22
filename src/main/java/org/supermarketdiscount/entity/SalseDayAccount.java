package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.dao.SalseDayAccountMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2015/7/6.
 */

public class SalseDayAccount implements Serializable {
    private Long accountid ;
    private Date purchaseDate;
    private Long commodityid;
    private Double salseCount;
    private Double profit;

    public void save() {
        ((SalseDayAccountMapper) SpringContextUtil.getBean("salseDayAccountMapper")).add(this);
    }

    public void del() {
        ((SalseDayAccountMapper) SpringContextUtil.getBean("salseDayAccountMapper")).del(this);
    }

    public void update() {
        ((SalseDayAccountMapper) SpringContextUtil.getBean("salseDayAccountMapper")).update(this);
    }

    public SalseDayAccount(){
        this.setProfit(0.0);
        this.setSalseCount(0.0);
        this.setCommodityid(new Long(0));
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Long commodityid) {
        this.commodityid = commodityid;
    }

    public Double getSalseCount() {
        return salseCount;
    }

    public void setSalseCount(Double salseCount) {
        this.salseCount = salseCount;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "SalseDayAccount{" +
                "accountid=" + accountid +
                ", purchaseDate=" + purchaseDate +
                ", commodityid=" + commodityid +
                ", salseCount=" + salseCount +
                ", profit=" + profit +
                '}';
    }
}
