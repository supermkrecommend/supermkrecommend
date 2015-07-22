package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/24.
 */
public class Commodity implements Serializable {
    private long commodityid;
    private long encode;
    private String commodityName;
    private String qualification;
    private long brandid;
    private String manufacture;
    private Integer typeid;
    private Integer orientationid;
    private String markids;
    private boolean isPromotion;
    private String shapeCode;
    private Double basePrice;
    private Double costPrice;           //成本价
    private Double consumeday;
    private boolean isquickSale;

    public void save() {
        ((CommodityMapper) SpringContextUtil.getBean("commodityMapper")).add(this);
    }

    public void del() {
        ((CommodityMapper) SpringContextUtil.getBean("commodityMapper")).del(this);
        UserDiscount userDiscount = new UserDiscount();
        userDiscount.setCommodityid(this.getCommodityid());
        userDiscount.delByCommodityid();
    }

    public void update() {
        ((CommodityMapper) SpringContextUtil.getBean("commodityMapper")).update(this);
    }

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

    public long getBrandid() {
        return brandid;
    }

    public void setBrandid(long brandid) {
        this.brandid = brandid;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getOrientationid() {
        return orientationid;
    }

    public void setOrientationid(Integer orientationid) {
        this.orientationid = orientationid;
    }

    public String getMarkids() {
        return markids;
    }

    public void setMarkids(String markids) {
        this.markids = markids;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(boolean isPromotion) {
        this.isPromotion = isPromotion;
    }


    public Double getBasePrice() {
        return basePrice;
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

    public String getShapeCode() {
        return shapeCode;
    }

    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getConsumeday() {
        return consumeday;
    }

    public void setConsumeday(Double consumeday) {
        this.consumeday = consumeday;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityid=" + commodityid +
                ", encode=" + encode +
                ", commodityName='" + commodityName + '\'' +
                ", qualification='" + qualification + '\'' +
                ", brandid=" + brandid +
                ", manufacture='" + manufacture + '\'' +
                ", typeid=" + typeid +
                ", orientationid=" + orientationid +
                ", markids='" + markids + '\'' +
                ", isPromotion=" + isPromotion +
                ", shapeCode='" + shapeCode + '\'' +
                ", basePrice=" + basePrice +
                ", costPrice=" + costPrice +
                ", consumeday=" + consumeday +
                ", isquickSale=" + isquickSale +
                '}';
    }
}
