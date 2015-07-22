package org.supermarketdiscount.facadeTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.PurchaseHistoryMapper;
import org.supermarketdiscount.entity.PurchaseHistory;
import org.supermarketdiscount.facade.DiscountFacade;
import org.supermarketdiscount.util.Arith;
import org.supermarketdiscount.util.DateGenerator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2015/6/13.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class DiscountFacadeTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DiscountFacade facade;
    @Autowired
    private PurchaseHistoryMapper mapper;
    @Test
    public void testCommodityDiscountCalculate()  throws ParseException {
        List<PurchaseHistory> list = this.getListPurchase(20, DateGenerator.getDate("2010-3-3"));
        for(PurchaseHistory history : list){
            facade.CommodityDiscountCalculate(history);
        }
    }

    private List<PurchaseHistory> getListPurchase(int serialCount,Date date){
        List<PurchaseHistory> list = new ArrayList<PurchaseHistory>();
        Random random = new Random();
        Long serialNumber = mapper.getNextSerialNumber();
        if(serialNumber == null){
            serialNumber = new Long(1);
        }
        for(int i = 0; i < serialCount ; i++){
            long userid = random.nextInt(5)+1;
            for(int j = 0 ; j < 5 ; j++){
                PurchaseHistory purchase = new PurchaseHistory();
                purchase.setUserid(userid);
                purchase.setSerialNumber(serialNumber);
                purchase.setShortDate(date);
                purchase.setCommodityid(random.nextInt(60)+1);
                purchase.setStoreNumber(0);
                purchase.setCounts((double) random.nextInt(5)+1);
                purchase.setSalsePrice((double)random.nextInt(12)+0.1);
                purchase.setCountPrice(Arith.mul(purchase.getCounts(),purchase.getSalsePrice()));
                list.add(purchase);
            }
            serialNumber ++;
        }
        return list;
    }
}