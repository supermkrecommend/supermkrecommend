package org.supermarketdiscount.dao;

import org.supermarketdiscount.dto.DetailCommodityDto;
import org.supermarketdiscount.dto.SimpleCommodityDto;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/25.
 */
public interface CommodityDtoMapper {
    List<DetailCommodityDto> getDetailCommodityDtoList(Map map);

    List<SimpleCommodityDto> getSimpleCommodityDtoList(Map map);
}
