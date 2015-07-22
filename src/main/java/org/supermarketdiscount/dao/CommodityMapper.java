package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.Commodity;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface CommodityMapper {
    long getMaxUuid();

    List<Commodity> getCommodityList(Map map);

    Commodity getCommodity(Map map);

    void del(Commodity commodity);

    void update(Commodity commodity);

    void add(Commodity commodity);
}
