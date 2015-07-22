package org.supermarketdiscount.filldata;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.entity.UserAddress;

/**
 * Created by Administrator on 2015/5/18.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class FillUserAddress extends AbstractJUnit4SpringContextTests {
    @Test
    public void fill() throws Exception {
        UserAddress address = new UserAddress();
        for(int i = 1 ; i < 601 ; i ++){
            for(int j = 1 ;  j < 5 ; j ++){
                address.setUserAddress("用户"+ i +"的地址:"+j);
                address.setPhoneNumber(String.valueOf(1390876539+i+j));
                address.setUseraddressid(i);
                address.setRecipientName("接收人"+j);
                address.setPostcode("712000");
                address.save();
            }

        }
    }
}