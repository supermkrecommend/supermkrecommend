package org.supermarketdiscount.dto;

import org.supermarketdiscount.entity.CommodityMark;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */
public class DetailCommodityDto implements Serializable {
    private long commodityid;
    private long encode;
    private String commodityName;
    //暂时不做
    private String qualification;
    //暂时不做
    private String brandName;
    private String manufacture;
    //商品分类暂时不做
    private String typeName;
    private String orientation;
    private String markids;
    //商品标签暂时不做
    private List<CommodityMark> marks;
    private double shapeCode;
    private double basePrice;
    private boolean isquickSale;

    public long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(long commodityid) {
        this.commodityid = commodityid;
    }

    public long getEncode() {
        return encode;
    }

    public void setEncode(long encode) {
        this.encode = encode;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }


    public double getShapeCode() {
        return shapeCode;
    }

    public void setShapeCode(double shapeCode) {
        this.shapeCode = shapeCode;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean getIsquickSale() {
        return isquickSale;
    }

    public boolean isquickSale() {
        return isquickSale;
    }

    public void setIsquickSale(boolean isquickSale) {
        this.isquickSale = isquickSale;
    }

    public String getMarkids() {
        return markids;
    }

    public void setMarkids(String markids) {
        this.markids = markids;
    }

    public List<CommodityMark> getMarks() {
        return marks;
    }

    public void setMarks(List<CommodityMark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "DetailCommodityDto{" +
                "commodityid=" + commodityid +
                ", encode=" + encode +
                ", commodityName='" + commodityName + '\'' +
                ", qualification='" + qualification + '\'' +
                ", brandName='" + brandName + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", typeName='" + typeName + '\'' +
                ", orientation='" + orientation + '\'' +
                ", markids='" + markids + '\'' +
                ", marks=" + marks +
                ", shapeCode=" + shapeCode +
                ", basePrice=" + basePrice +
                ", isquickSale=" + isquickSale +
                '}';
    }
}
