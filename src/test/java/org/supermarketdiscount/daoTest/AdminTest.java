package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.AdminMapper;
import org.supermarketdiscount.entity.Admin;
import org.supermarketdiscount.entity.Brand;

/**
 * Created by Administrator on 2015/6/2.
 */
@ContextConfiguration(locations = {"classpath:org/config/spring/testApplicationContext.xml"})
public class AdminTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private AdminMapper Mapper;

    @Test
    public void testadd() {
        Admin admin = new Admin();
        for (int i = 20; i < 22; i++) {
            admin.setPassword(i + "");
            admin.setUsername(i + "");
            Mapper.add(admin);
        }
    }
}