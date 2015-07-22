package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.DiscountStandardMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/24.
 */
public class DiscountStandard implements Serializable {
    private long salsePriceid;
    private long commodityid;
    private Integer promotionstandard;
    private Double salse;
    private Integer minCount;
    private Integer maxCount;
    private Integer alterAmount;

    public void save() {
        DiscountStandardMapper mapper = (DiscountStandardMapper) SpringContextUtil.getBean("discountStandardMapper");
        Long uuid = mapper.getMaxUuid();
        if (uuid == null) {
            uuid = new Long(1);
        }
        this.setSalsePriceid(uuid);
        mapper.add(this);
    }

    public void del() {
        ((DiscountStandardMapper) SpringContextUtil.getBean("discountStandardMapper")).del(this);
    }

    public void delByCommodityid() {
        ((DiscountStandardMapper) SpringContextUtil.getBean("discountStandardMapper")).delByCommodityid(this);
    }

    public void update() {
        ((DiscountStandardMapper) SpringContextUtil.getBean("discountStandardMapper")).update(this);
    }

    public long getSalsePriceid() {
        return salsePriceid;
    }

    public void setSalsePriceid(long salsePriceid) {
        this.salsePriceid = salsePriceid;
    }

    public long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(long commodityid) {
        this.commodityid = commodityid;
    }


    public Double getSalse() {
        return salse;
    }

    public void setSalse(double salse) {
        this.salse = salse;
    }
    public Double getPromotionsalse() {
        return salse;
    }

    public Integer getMinCount() {
        return minCount;
    }

    public void setMinCount(Integer minCount) {
        this.minCount = minCount;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public Integer getAlterAmount() {
        return alterAmount;
    }

    public void setAlterAmount(Integer alterAmount) {
        this.alterAmount = alterAmount;
    }

    public Integer getPromotionstandard() {
        return promotionstandard;
    }

    public void setPromotionstandard(Integer promotionstandard) {
        this.promotionstandard = promotionstandard;
    }

    @Override
    public String toString() {
        return "DiscountStandard{" +
                "salsePriceid=" + salsePriceid +
                ", commodityid=" + commodityid +
                ", promotionstandard=" + promotionstandard +
                ", salse=" + salse +
                ", minCount=" + minCount +
                ", maxCount=" + maxCount +
                ", alterAmount=" + alterAmount +
                '}';
    }
}
