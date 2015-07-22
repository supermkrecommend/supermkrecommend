package org.supermarketdiscount.filldata;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.entity.DiscountCalculateTime;
import org.supermarketdiscount.entity.DiscountStandard;
import  java.util.Random;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2015/5/18.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class FillDiscountCalculateTime extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CommodityMapper mapper;

    @Test
    public void fill() throws Exception {
        int pageCoun = 100;
        int currentPage =  1;
        PageHelper.startPage(currentPage, 100);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Random random = new  Random();
        List<Commodity> list =  mapper.getCommodityList(null);
        PageInfo page = new PageInfo(list);
        pageCoun = page.getPages();
        DiscountCalculateTime standard = new DiscountCalculateTime();
        for(;currentPage < pageCoun;currentPage++) {
            PageHelper.startPage(currentPage, 200);
            list = mapper.getCommodityList(null);
            for (Commodity commodity : list) {
                standard.setSpaceTime(random.nextInt(30)+30);
                standard.setCommodityid(commodity.getCommodityid());
                standard.setLastDate(sdf.parse("2000-1-1"));
                standard.save();
            }
        }
    }

}