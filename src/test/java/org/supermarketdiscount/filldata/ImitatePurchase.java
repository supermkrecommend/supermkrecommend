package org.supermarketdiscount.filldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dto.PurchaseHistoryDto;
import org.supermarketdiscount.entity.PurchaseHistory;
import org.supermarketdiscount.facade.DiscountFacade;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/5/18.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class ImitatePurchase extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DiscountFacade discountFacade;
    @Test
    public void testPurchase() throws ParseException {
        PurchaseHistory dto = new PurchaseHistory();
        dto.setCommodityid(1);
        dto.setUserid(1);
        dto.setCounts(50.0);
        discountFacade.CommodityDiscountCalculate(dto);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        discountFacade.refreshUserDiscount(sdf.parse("2010-03-01"));
    }
    @Test
    public void testRefreshUserDiscount() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        discountFacade.refreshUserDiscount(sdf.parse("2010-03-01"));
    }
}