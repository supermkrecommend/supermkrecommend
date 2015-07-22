package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.SalseDayAccount;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/7/6.
 */
public interface SalseDayAccountMapper {
    List<SalseDayAccount> getSalseDayAccount(Map map);
    void add(SalseDayAccount account);
    void del(SalseDayAccount account);
    void update(SalseDayAccount account);
}
