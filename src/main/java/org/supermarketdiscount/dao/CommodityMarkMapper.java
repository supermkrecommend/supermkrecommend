package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.CommodityMark;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface CommodityMarkMapper {
    List<CommodityMark> getCommodityMarkList(Map map);

    CommodityMark getCommodityMark(Map map);

    List<CommodityMark> getCommoditymarkListByIds(Map map);

    void update(CommodityMark commodityMark);

    void add(CommodityMark commodityMark);

    void del(CommodityMark commodityMark);
}
