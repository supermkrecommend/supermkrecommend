package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.DiscountCalculateTimeMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/24.
 */
public class DiscountCalculateTime implements Serializable {
    private long commodityid;
    private Date lastDate;
    private Integer spaceTime;
    private Integer alertAheadTime;

    public void save() {
        ((DiscountCalculateTimeMapper) SpringContextUtil.getBean("discountCalculateTimeMapper")).add(this);
    }

    public void del() {
        ((DiscountCalculateTimeMapper) SpringContextUtil.getBean("discountCalculateTimeMapper")).del(this);
    }

    public void update() {
        ((DiscountCalculateTimeMapper) SpringContextUtil.getBean("discountCalculateTimeMapper")).update(this);
    }

    public long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(long commodityid) {
        this.commodityid = commodityid;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        this.spaceTime = spaceTime;
    }

    public Integer getAlertAheadTime() {
        return alertAheadTime;
    }

    public void setAlertAheadTime(Integer alertAheadTime) {
        this.alertAheadTime = alertAheadTime;
    }

    @Override
    public String toString() {
        return "DiscountCalculateTime{" +
                "commodityid=" + commodityid +
                ", lastDate=" + lastDate +
                ", spaceTime=" + spaceTime +
                ", alertAheadTime=" + alertAheadTime +
                '}';
    }
}
