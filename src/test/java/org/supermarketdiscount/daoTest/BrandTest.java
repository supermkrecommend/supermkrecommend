package org.supermarketdiscount.daoTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.BrandMapper;
import org.supermarketdiscount.entity.Brand;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class BrandTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private BrandMapper brandMapper;
    @Test
    public void testadd(){
        Brand brand = new Brand();
        for(int i = 0 ; i < 10; i++){
            brand.setBrandid(i);
            brand.setBrandName("asdf");
            brandMapper.add(brand);
        }
    }
    @Test
    public void select(){
        long[] time = new long[4];
        time[0] = System.currentTimeMillis();
        PageHelper.startPage(1, 2);
        time[1] = System.currentTimeMillis();
        List<Brand> list =  brandMapper.getBrandList(null);
        time[2] = System.currentTimeMillis();
        PageInfo page = new PageInfo(list);
        time[3] = System.currentTimeMillis();
        for(Brand brand :list){
            System.out.println(brand.toString());
        }

        for(int i = 0 ; i < 3 ; i ++){
            System.out.println(time[i+1] - time[i]);
        }
//        List<Brand> list = ((BrandMapper) SpringContextUtil.getBean("brandMapper")).getBrandList(null);
//        for(Brand brand :list){
//            System.out.println(brand.toString());
//        }
    }
    @Test
    public void selectOne(){
        Map map = new HashMap();
        map.put("brandid",0);
        Brand brand = brandMapper.getBrand(map);
        System.out.println(brand.toString());
    }
    @Test
    public void selectTest(){
        PageHelper.startPage(1, 2);
        BrandMapper mapper =  ((BrandMapper)SpringContextUtil.getBean("brandMapper"));
        List<Brand> list = mapper.getBrandList(null);
        PageInfo page = new PageInfo(list);
        for(Brand temp : list){
            System.out.println(temp.toString());
        }
    }
    @Test
    public void update(){
        List<Brand> list =  brandMapper.getBrandList(null);
        for(Brand brand :list){
            brand.setBrandName(brand.getBrandName()+"testadd");
            brandMapper.update(brand);
        }
    }
    @Test
    public void del(){
        List<Brand> list =  brandMapper.getBrandList(null);
        for(Brand brand :list){
            brandMapper.del(brand);
        }
    }
}
