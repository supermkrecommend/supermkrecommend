package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.DiscountCalculateTimeMapper;
import org.supermarketdiscount.entity.DiscountCalculateTime;
import org.supermarketdiscount.util.DateGenerator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class DiscountCalculateTimeTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DiscountCalculateTimeMapper mapper;
    @Test
    public void add(){
        DiscountCalculateTime temp = new DiscountCalculateTime();
        for(int i = 0 ; i < 10 ; i++){
            temp.setCommodityid(i);
            temp.setLastDate(new Date());
            temp.setSpaceTime(i);
            mapper.add(temp);
        }
        this.select();
    }
    @Test
    public void selectRefreshTest(){
        Map map = new HashMap();
        map.put("date", DateGenerator.getDateBefore(new Date(), -2));
        List<DiscountCalculateTime> list =  mapper.getCalculateCommodityList(map);
        for(DiscountCalculateTime temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void update(){
        List<DiscountCalculateTime> list =  mapper.getDiscountCalculateTimeList(null);
        for(DiscountCalculateTime temp : list){
            temp.setSpaceTime(temp.getSpaceTime()+10);
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<DiscountCalculateTime> list =  mapper.getDiscountCalculateTimeList(null);
        for(DiscountCalculateTime temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<DiscountCalculateTime> list =  mapper.getDiscountCalculateTimeList(null);
        for(DiscountCalculateTime temp : list){
            mapper.del(temp);
        }
        this.select();
    }
}