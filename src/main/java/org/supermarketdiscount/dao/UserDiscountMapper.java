package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.UserDiscount;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface UserDiscountMapper {
    List<UserDiscount> getUserDiscountList(Map map);

    List<UserDiscount> getMessageUserDiscount(Map map);

    UserDiscount getUserDiscount(Map map);

    List<UserDiscount> getforecastUserDiscount(Map map);

    void update(UserDiscount userDiscount);

    void add(UserDiscount userDiscount);

    void del(UserDiscount userDiscount);
}
