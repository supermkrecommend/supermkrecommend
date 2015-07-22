package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.UserDiscountMapper;
import org.supermarketdiscount.entity.UserDiscount;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class UserDiscountTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private UserDiscountMapper mapper;
    @Test
    public void add(){
        UserDiscount temp = new UserDiscount();
        for(int i = 0 ; i < 10 ; i++){
            temp.setCommodityid(new Long(i));
            temp.setPromotionPrice(Double.valueOf(i));
            temp.setPromotionstandard(i);
            temp.setSalseCount(Double.valueOf(i));
            temp.setTypeid(new Long(i));
            temp.setUserid(new Long(i));
            mapper.add(temp);
        }
        this.select();
    }
    @Test
    public void update(){
        List<UserDiscount> list = mapper.getUserDiscountList(null);
        for(UserDiscount temp : list){
            temp.setSalseCount(temp.getSalseCount() +20);
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<UserDiscount> list = mapper.getUserDiscountList(null);
        for(UserDiscount temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<UserDiscount> list = mapper.getUserDiscountList(null);
        for(UserDiscount temp : list){
            mapper.del(temp);
        }
        this.select();
    }
}