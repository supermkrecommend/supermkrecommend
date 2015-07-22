package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.PromotionPriceMapper;
import org.supermarketdiscount.entity.PromotionPrice;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class PromotionPriceTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private PromotionPriceMapper mapper;
    @Test
    public void add(){
        PromotionPrice temp = new PromotionPrice();
        for(int i = 0 ; i < 10 ; i++){
            temp.setSalse(i);
            temp.setCommodityid(i);
            temp.setPromotionid(i);
            temp.setSalseEndDate(new Date());
            temp.setSalseEndDate(new Date());
            mapper.add(temp);
        }
        this.select();
    }
    @Test
    public void update(){
        List<PromotionPrice> list =  mapper.getPromotionPriceList(null);
        for(PromotionPrice temp : list){
            temp.setSalse(temp.getSalse()+20);
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<PromotionPrice> list =  mapper.getPromotionPriceList(null);
        for(PromotionPrice temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<PromotionPrice> list =  mapper.getPromotionPriceList(null);
        for(PromotionPrice temp : list){
            mapper.del(temp);
        }
        this.select();
    }
}