package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.PurchaseHistoryMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/24.
 */
public class PurchaseHistory implements Serializable {
    private long purchaseid;
    private long serialNumber;
    private long userid;
    private Integer storeNumber;
    private Date shortDate;
    private long commodityid;
    private Double counts;
    private Double salsePrice;
    private Double countPrice;

    public void save() {
        ((PurchaseHistoryMapper) SpringContextUtil.getBean("purchaseHistoryMapper")).add(this);
    }

    public void del() {
        ((PurchaseHistoryMapper) SpringContextUtil.getBean("purchaseHistoryMapper")).del(this);
    }

    public void update() {
        ((PurchaseHistoryMapper) SpringContextUtil.getBean("purchaseHistoryMapper")).update(this);
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Date getShortDate() {
        return shortDate;
    }

    public void setShortDate(Date shortDate) {
        this.shortDate = shortDate;
    }

    public long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(long commodityid) {
        this.commodityid = commodityid;
    }

    public Double getCounts() {
        return counts;
    }

    public void setCounts(Double counts) {
        this.counts = counts;
    }

    public Double getSalsePrice() {
        return salsePrice;
    }

    public void setSalsePrice(Double salsePrice) {
        this.salsePrice = salsePrice;
    }

    public Double getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(Double countPrice) {
        this.countPrice = countPrice;
    }

    public long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(long purchaseid) {
        this.purchaseid = purchaseid;
    }

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "userid=" + userid +
                ", serialNumber=" + serialNumber +
                ", storeNumber=" + storeNumber +
                ", shortDate=" + shortDate +
                ", commodityid=" + commodityid +
                ", counts=" + counts +
                ", salsePrice=" + salsePrice +
                ", countPrice=" + countPrice +
                '}';
    }
}
