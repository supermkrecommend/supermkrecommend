package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.CommodityMarkMapper;
import org.supermarketdiscount.entity.CommodityMark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/25.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class CommodityMarkTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CommodityMarkMapper mapper;
    @Test
    public void add(){
        CommodityMark temp = new CommodityMark();
        for(int i = 0 ; i < 10 ; i++){
            temp.setMarkid(i);
            temp.setDescribtion("有很多爱"+i);
            mapper.add(temp);
        }
    }
    @Test
    public void update(){
        List<CommodityMark> list = mapper.getCommodityMarkList(null);
        for(CommodityMark mark : list){
            mark.setDescribtion(mark.getDescribtion()+"test");
            mapper.update(mark);
        }
    }
    @Test
    public void select(){
        List<CommodityMark> list = mapper.getCommodityMarkList(null);
        for(CommodityMark mark : list){
            System.out.println(mark.toString());
        }
    }
    @Test
    public void selectIds(){
        List ids = new ArrayList();
        for(int i = 0 ; i < 3 ; i ++)
            ids.add(i);
        Map map = new HashMap();
        map.put("ids",ids);
        List<CommodityMark> lists = mapper.getCommoditymarkListByIds(map);
        for(CommodityMark mark : lists){
            System.out.println(mark.toString());
        }
    }
    @Test
    public void del(){
        List<CommodityMark> list = mapper.getCommodityMarkList(null);
        for(CommodityMark mark : list){
            mapper.del(mark);
        }
    }
}
