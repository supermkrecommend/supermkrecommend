package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.ProductionOrientation;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface ProductionOrientationMapper {
    List<ProductionOrientation> getProductionOrientationList(Map map);

    ProductionOrientation getProductionOrientation(Map map);

    void update(ProductionOrientation productionOrientation);

    void add(ProductionOrientation productionOrientation);

    void del(ProductionOrientation productionOrientation);
}
