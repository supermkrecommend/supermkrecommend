package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.entity.Commodity;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class CommodityTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CommodityMapper mapper;
    @Test
    public void add(){
        Commodity temp = new Commodity();
        for(int i = 0 ; i < 10 ; i++){
            temp.setBrandid(i);
            temp.setBasePrice(Double.valueOf(i));
            temp.setCommodityName(i + "");
            temp.setEncode(i);
            temp.setTypeid(i);
            temp.setIsPromotion(false);
            temp.setManufacture(i + "");
            temp.setMarkids(i + "");
            temp.setOrientationid(i);
            temp.setQualification(i+"");
            temp.setIsquickSale(false);
            temp.setShapeCode(i+"");
            mapper.add(temp);
        }
    }
    @Test
    public void update(){
        List<Commodity> list =  mapper.getCommodityList(null);
        for(Commodity temp : list){
            temp.setBasePrice(temp.getBasePrice()+10);
            mapper.update(temp);
        }
    }
    @Test
    public void select(){
        List<Commodity> list =  mapper.getCommodityList(null);
        for(Commodity temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<Commodity> list =  mapper.getCommodityList(null);
        for(Commodity temp : list){
            mapper.del(temp);
        }
    }
}