package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.PurchaseHistory;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface PurchaseHistoryMapper {
    List<PurchaseHistory> getPurchaseHistoryList(Map map);

    PurchaseHistory getPurchaseHistory(Map map);

    Long getNextSerialNumber();
    Double getConsumeDay(Map map);
    List<Long> getDistinctCommodityid(Map map);
    void add(PurchaseHistory purchaseHistory);

    void del(PurchaseHistory purchaseHistory);

    void update(PurchaseHistory purchaseHistory);
}
