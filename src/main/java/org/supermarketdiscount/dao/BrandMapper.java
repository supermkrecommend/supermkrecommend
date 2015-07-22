package org.supermarketdiscount.dao;


import org.supermarketdiscount.entity.Brand;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface BrandMapper {
    List<Brand> getBrandList(Map map);

    Brand getBrand(Map map);

    void del(Brand brand);

    void update(Brand brand);

    void add(Brand brand);
}
