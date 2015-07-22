package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.PromotionHistory;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/7/6.
 */
public interface PromotionHistoryMapper {
    List<PromotionHistory> getPromotionHistory(Map map);
    void add(PromotionHistory history);
    void del(PromotionHistory history);
    void update(PromotionHistory history);
}
