package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.UserAddress;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/25.
 */
public interface UserAddressMapper {
    List<UserAddress> getUserAddressList(Map map);

    UserAddress getUserAddress(Map map);

    long getMaxUuid();

    void add(UserAddress userAddress);

    void update(UserAddress userAddress);

    void del(UserAddress userAddress);
}
