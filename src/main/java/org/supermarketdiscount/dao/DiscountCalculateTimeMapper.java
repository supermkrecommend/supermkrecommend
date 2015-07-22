package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.DiscountCalculateTime;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface DiscountCalculateTimeMapper {
    List<DiscountCalculateTime> getDiscountCalculateTimeList(Map map);

    List<DiscountCalculateTime> getCalculateCommodityList(Map map);


    DiscountCalculateTime getDiscountCalculateTime(Map map);

    void add(DiscountCalculateTime discountCalculateTime);

    void del(DiscountCalculateTime discountCalculateTime);

    void update(DiscountCalculateTime discountCalculateTime);
}
