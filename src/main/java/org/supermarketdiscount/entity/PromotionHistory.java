package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.ProductionOrientationMapper;
import org.supermarketdiscount.dao.PromotionHistoryMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2015/7/6.
 */
public class PromotionHistory implements Serializable {
    private Long historyid;
    private Long userid;
    private Long commodityid;
    private Date sendDate;
    private boolean backFlag;
    private Integer forecastDay;
    private Double backAmount;
    private Integer promotionType;
    public PromotionHistory(){
        this.setBackAmount(0.0);
        this.setBackFlag(false);
    }
    public PromotionHistory(UserDiscount discount,Date date,int type){
        this.setSendDate(date);
        this.setBackFlag(false);
        this.setBackAmount(0.0);
        this.setCommodityid(discount.getCommodityid());
        this.setUserid(discount.getUserid());
        this.setPromotionType(type);
    }
    public void save() {
        ((PromotionHistoryMapper) SpringContextUtil.getBean("promotionHistoryMapper")).add(this);
    }

    public void del() {
        ((PromotionHistoryMapper) SpringContextUtil.getBean("promotionHistoryMapper")).del(this);
    }

    public void update() {
        ((PromotionHistoryMapper) SpringContextUtil.getBean("promotionHistoryMapper")).update(this);
    }

    public Long getHistoryid() {
        return historyid;
    }

    public void setHistoryid(Long historyid) {
        this.historyid = historyid;
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isBackFlag() {
        return backFlag;
    }

    public void setBackFlag(boolean backFlag) {
        this.backFlag = backFlag;
    }

    public Double getBackAmount() {
        return backAmount;
    }

    public void setBackAmount(Double backAmount) {
        this.backAmount = backAmount;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(Integer forecastDay) {
        this.forecastDay = forecastDay;
    }

    @Override
    public String toString() {
        return "PromotionHistory{" +
                "historyid=" + historyid +
                ", userid=" + userid +
                ", commodityid=" + commodityid +
                ", sendDate=" + sendDate +
                ", backFlag=" + backFlag +
                ", forecastDay=" + forecastDay +
                ", backAmount=" + backAmount +
                ", promotionType=" + promotionType +
                '}';
    }
}
