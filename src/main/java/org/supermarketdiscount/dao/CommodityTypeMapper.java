package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.CommodityType;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface CommodityTypeMapper {
    List<CommodityType> getCommodityTypeList(Map map);

    CommodityType getCommodityTypeById(Long typeid);

    void update(CommodityType commodityType);

    void add(CommodityType commodityType);

    void del(CommodityType commodityType);
}
