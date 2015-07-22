package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.DiscountStandardMapper;
import org.supermarketdiscount.entity.DiscountStandard;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class DiscountStandardTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DiscountStandardMapper mapper;
    @Test
    public void add(){
        DiscountStandard temp = new DiscountStandard();
        for( int i = 0 ; i < 10 ; i++){
            temp.setCommodityid(i);
            temp.setMaxCount(i + 20);
            temp.setMinCount(i);
            temp.setPromotionstandard(i);
            temp.setSalse(i);
            temp.setSalsePriceid(i);
            mapper.add(temp);
        }
        this.select();
    }
    @Test
    public void update(){
        List<DiscountStandard> list =  mapper.getDiscountStandardList(null);
        for(DiscountStandard temp : list){
            temp.setSalse(temp.getSalsePriceid()+20);
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<DiscountStandard> list =  mapper.getDiscountStandardList(null);
        for(DiscountStandard temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<DiscountStandard> list =  mapper.getDiscountStandardList(null);
        for(DiscountStandard temp : list){
            mapper.del(temp);
        }
        this.select();
    }
}