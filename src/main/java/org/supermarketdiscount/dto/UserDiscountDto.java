package org.supermarketdiscount.dto;

import org.supermarketdiscount.entity.CommodityType;

/**
 * Created by Administrator on 2015/4/25.
 */
public class UserDiscountDto {
    private long userid;
    private SimpleCommodityDto commodity;
    private CommodityType type;
    private double promotionPrice;
    private Integer promotionstandard;
    private Integer salseCount;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public SimpleCommodityDto getCommodity() {
        return commodity;
    }

    public void setCommodity(SimpleCommodityDto commodity) {
        this.commodity = commodity;
    }

    public CommodityType getType() {
        return type;
    }

    public void setType(CommodityType type) {
        this.type = type;
    }

    public Integer getPromotionstandard() {
        return promotionstandard;
    }

    public void setPromotionstandard(Integer promotionstandard) {
        this.promotionstandard = promotionstandard;
    }

    public Integer getSalseCount() {
        return salseCount;
    }

    public void setSalseCount(Integer salseCount) {
        this.salseCount = salseCount;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    @Override
    public String toString() {
        return "UserDiscountDto{" +
                "userid=" + userid +
                ", commodity=" + commodity +
                ", type='" + type + '\'' +
                ", promotionPrice=" + promotionPrice +
                ", promotionstandard=" + promotionstandard +
                ", salseCount=" + salseCount +
                '}';
    }
}
