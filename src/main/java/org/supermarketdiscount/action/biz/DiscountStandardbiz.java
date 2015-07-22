package org.supermarketdiscount.action.biz;

import org.supermarketdiscount.entity.DiscountStandard;

/**
 * Created by Administrator on 2015/5/7.
 */
public class DiscountStandardbiz {
    private Integer promotionstandard ;
    private String discountStandard;
    public DiscountStandardbiz(DiscountStandard discount){
        this.setPromotionstandard(discount.getPromotionstandard());
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.valueOf(discount.getSalse())).append("/");
        buffer.append(String.valueOf(discount.getMinCount())).append("/");
        buffer.append(String.valueOf(discount.getMaxCount())).append("/");
        buffer.append(String.valueOf(discount.getPromotionstandard())).append("/");
        this.setDiscountStandard(buffer.toString());
    }

    public Integer getPromotionstandard() {
        return promotionstandard;
    }

    public void setPromotionstandard(Integer promotionstandard) {
        this.promotionstandard = promotionstandard;
    }

    public String getDiscountStandard() {
        return discountStandard;
    }

    public void setDiscountStandard(String discountStandard) {
        this.discountStandard = discountStandard;
    }
}
