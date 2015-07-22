package org.supermarketdiscount.dto;

import java.util.Date;

/**
 * Created by Administrator on 2015/4/25.
 */
public class PromotionDto {
    private long promotionid;
    private SimpleCommodityDto commodity;
    private double salse;
    private Date salseStartDate;
    private Date salseEndDate;

    public long getPromotionid() {
        return promotionid;
    }

    public void setPromotionid(long promotionid) {
        this.promotionid = promotionid;
    }

    public SimpleCommodityDto getCommodity() {
        return commodity;
    }

    public void setCommodity(SimpleCommodityDto commodity) {
        this.commodity = commodity;
    }

    public double getSalse() {
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
        return "PromotionDto{" +
                "promotionid=" + promotionid +
                ", commodity=" + commodity +
                ", salse=" + salse +
                ", salseStartDate=" + salseStartDate +
                ", salseEndDate=" + salseEndDate +
                '}';
    }
}
