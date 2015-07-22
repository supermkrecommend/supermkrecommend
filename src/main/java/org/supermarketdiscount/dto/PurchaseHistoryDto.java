package org.supermarketdiscount.dto;

import java.util.Date;

/**
 * Created by Administrator on 2015/4/26.
 */
public class PurchaseHistoryDto {
    private long purchaseid;
    private long userid;
    private long serialNumber;
    private Integer storeNumber;
    private Date shortDate;
    private long commodityid;
    private Double counts;
    private Double salsePrice;
    private Double countPrice;

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

    public double getSalsePrice() {
        return salsePrice;
    }

    public void setSalsePrice(double salsePrice) {
        this.salsePrice = salsePrice;
    }

    public double getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(double countPrice) {
        this.countPrice = countPrice;
    }

    public long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public void setSalsePrice(Double salsePrice) {
        this.salsePrice = salsePrice;
    }

    public void setCountPrice(Double countPrice) {
        this.countPrice = countPrice;
    }

    @Override
    public String toString() {
        return "PurchaseHistoryDto{" +
                "purchaseid=" + purchaseid +
                ", userid=" + userid +
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
