package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.DiscountStandard;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface DiscountStandardMapper {
    List<DiscountStandard> getDiscountStandardList(Map map);

    DiscountStandard getDiscountStandard(Map map);

    Long getMaxUuid();

    void add(DiscountStandard discountStandard);

    void del(DiscountStandard discountStandard);

    void delByCommodityid(DiscountStandard discountStandard);

    void update(DiscountStandard discountStandard);
}
