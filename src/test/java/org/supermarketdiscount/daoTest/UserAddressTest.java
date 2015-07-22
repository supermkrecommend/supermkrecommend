package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.UserAddressMapper;
import org.supermarketdiscount.entity.UserAddress;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class UserAddressTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private UserAddressMapper mapper;
    @Test
    public void add(){
        UserAddress temp = new UserAddress();
        for(int i = 0 ; i < 10 ; i++){
            temp.setAddressKey(i);
            temp.setUseraddressid(i);
            temp.setUserAddress(i+"");
            mapper.add(temp);
        }
        this.select();
    }
    @Test
    public void update(){
        List<UserAddress> list =  mapper.getUserAddressList(null);
        for(UserAddress temp : list){
            temp.setUserAddress(temp.getUserAddress()+"test");
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<UserAddress> list =  mapper.getUserAddressList(null);
        for(UserAddress temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<UserAddress> list =  mapper.getUserAddressList(null);
        for(UserAddress temp : list){
            mapper.del(temp);
        }
        this.select();
    }
}
