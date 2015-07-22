package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.BrandMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/24.
 */
public class Brand implements Serializable {
    private long brandid;
    private String brandName;

    public void save() {
        ((BrandMapper) SpringContextUtil.getBean("brandMapper")).add(this);
    }

    public void del() {
        ((BrandMapper) SpringContextUtil.getBean("brandMapper")).del(this);
    }

    public void update() {
        ((BrandMapper) SpringContextUtil.getBean("brandMapper")).update(this);
    }

    public long getBrandid() {
        return brandid;
    }

    public void setBrandid(long brandid) {
        this.brandid = brandid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandid=" + brandid +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
