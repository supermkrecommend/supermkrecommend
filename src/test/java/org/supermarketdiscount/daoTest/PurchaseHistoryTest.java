package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.PurchaseHistoryMapper;
import org.supermarketdiscount.entity.PurchaseHistory;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class PurchaseHistoryTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private PurchaseHistoryMapper mapper;
    @Test
    public void add(){
        PurchaseHistory temp = new PurchaseHistory();
        for(int i = 0 ; i < 10 ; i ++){
            temp.setUserid(i);
            temp.setCommodityid(i);
            temp.setCountPrice(Double.valueOf(i));
            temp.setCounts(Double.valueOf(i));
            temp.setStoreNumber(i);
            temp.setSalsePrice(Double.valueOf(i));
            temp.setSerialNumber(i);
            temp.setShortDate(new Date());
            mapper.add(temp);
        }
        this.select();
    }
    @Test
    public void update(){
        List<PurchaseHistory>  list = mapper.getPurchaseHistoryList(null);
        for( PurchaseHistory temp : list){
            temp.setCountPrice(temp.getCountPrice()+20);
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<PurchaseHistory>  list = mapper.getPurchaseHistoryList(null);
        for( PurchaseHistory temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<PurchaseHistory>  list = mapper.getPurchaseHistoryList(null);
        for( PurchaseHistory temp : list){
            mapper.del(temp);
        }
        this.select();
    }
}