package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.ProductionOrientationMapper;
import org.supermarketdiscount.entity.ProductionOrientation;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class ProductionOrientationTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private ProductionOrientationMapper mapper;
    @Test
    public void add(){
        ProductionOrientation temp = new ProductionOrientation();
        for(int i = 0 ; i < 10 ; i++){
            temp.setOrientationDescribtion(i+"");
            temp.setOrientationid(i);
            mapper.add(temp);
        }
        this.select();
    }
    @Test
    public void update(){
        List<ProductionOrientation> list =  mapper.getProductionOrientationList(null);
        for(ProductionOrientation temp : list){
            temp.setOrientationDescribtion(temp.getOrientationDescribtion() +"test");
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<ProductionOrientation> list =  mapper.getProductionOrientationList(null);
        for(ProductionOrientation temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<ProductionOrientation> list =  mapper.getProductionOrientationList(null);
        for(ProductionOrientation temp : list){
            mapper.del(temp);
        }
        this.select();
    }
}