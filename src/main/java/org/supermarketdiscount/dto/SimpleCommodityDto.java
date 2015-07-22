package org.supermarketdiscount.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/25.
 */
public class SimpleCommodityDto implements Serializable {
    private String commodityName;
    private long commodityid;
    private double basePrice;
    private boolean isquickSale;
    private String qualification;
    private String manufacture;

    public long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(long commodityid) {
        this.commodityid = commodityid;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isquickSale() {
        return isquickSale;
    }

    public boolean getIsquickSale() {
        return isquickSale;
    }

    public void setIsquickSale(boolean isquickSale) {
        this.isquickSale = isquickSale;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "SimpleCommodityDto{" +
                "commodityName='" + commodityName + '\'' +
                ", commodityid=" + commodityid +
                ", basePrice=" + basePrice +
                ", isquickSale=" + isquickSale +
                ", qualification='" + qualification + '\'' +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
