package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.CommodityTypeMapper;
import org.supermarketdiscount.entity.CommodityType;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class CommodityTypeTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CommodityTypeMapper mapper;
    @Test
    public void add(){
        CommodityType temp = new CommodityType();
        for(int i = 0 ; i < 10 ; i++){
            temp.setTypeid(i);
            temp.setTypeName("asdfa");
            mapper.add(temp);
        }
    }
    @Test
    public void update(){
        List<CommodityType> list = mapper.getCommodityTypeList(null);
        for(CommodityType temp : list){
            temp.setTypeName(temp.getTypeName()+"test");
            mapper.update(temp);
        }
    }
    @Test
    public void select(){
        List<CommodityType> list = mapper.getCommodityTypeList(null);
        for(CommodityType temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<CommodityType> list = mapper.getCommodityTypeList(null);
        for(CommodityType temp : list){
            mapper.del(temp);
        }
    }
}