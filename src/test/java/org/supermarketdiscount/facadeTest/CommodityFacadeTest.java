package org.supermarketdiscount.facadeTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.facade.CommodityFacade;
import org.supermarketdiscount.facade.DiscountFacade;
import org.supermarketdiscount.util.DateGenerator;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/26.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class CommodityFacadeTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CommodityFacade facade;
    @Autowired
    private DiscountFacade discountFacade;
    @Test
    public void getCommodityPriceTest(){
        long time1 = System.currentTimeMillis();
        facade.getCommodityPrice(0,0);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
    @Test
    public void refreshUserDiscount() throws ParseException {
        discountFacade.refreshUserDiscount(DateGenerator.getDate("2010-3-7"));
    }

}
