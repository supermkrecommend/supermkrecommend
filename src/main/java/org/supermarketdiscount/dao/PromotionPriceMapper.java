package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.PromotionPrice;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface PromotionPriceMapper {
    List<PromotionPrice> getPromotionPriceList(Map map);

    PromotionPrice getPromotionPrice(Map map);

    void update(PromotionPrice promotionPrice);

    void add(PromotionPrice promotionPrice);

    void del(PromotionPrice promotionPrice);

    void delByCommodityid(PromotionPrice promotionPrice);
}
