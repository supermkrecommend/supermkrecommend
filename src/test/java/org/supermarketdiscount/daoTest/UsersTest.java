package org.supermarketdiscount.daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.UsersMapper;
import org.supermarketdiscount.entity.Users;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class UsersTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private UsersMapper mapper;
    @Test
    public void add(){
        Users temp = new Users();
        long time1,time2;
        for(int i = 0 ; i < 10 ; i++){
            temp.setMembership(i);
            temp.setPassword(i + "");
            temp.setPhoneNumber(i + "");
            temp.setUseraddressid(i);
            temp.setUsername(i + "");
            time1 = System.currentTimeMillis();
            mapper.add(temp);
            time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        }
//        this.select();
    }
    @Test
    public void update(){
        List<Users> list =  mapper.getUsersList(null);
        for(Users temp : list){
            temp.setUsername(temp.getUsername()+"test");
            mapper.update(temp);
        }
        this.select();
    }
    @Test
    public void select(){
        List<Users> list =  mapper.getUsersList(null);
        for(Users temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void del(){
        List<Users> list =  mapper.getUsersList(null);
        for(Users temp : list){
            mapper.del(temp);
        }
        this.select();
    }

}