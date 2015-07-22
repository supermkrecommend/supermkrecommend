package org.supermarketdiscount.filldata;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.entity.Users;

/**
 * Created by Administrator on 2015/5/18.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class FillUsers extends AbstractJUnit4SpringContextTests {
    @Test
    public void fill() throws Exception {
        Users user = new Users();
        for(int i = 1 ; i < 601 ; i++){
            user.setUsername("用户"+i);
            user.setPhoneNumber(1390569872+i+"");
            user.setPassword(String.valueOf(i));
            user.setMembership(i);
            user.setUseraddressid(i);
            user.setUserid(i);
            user.save();
        }
    }
}