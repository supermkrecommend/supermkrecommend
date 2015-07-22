package org.supermarketdiscount.filldata;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.dao.DiscountStandardMapper;
import org.supermarketdiscount.entity.Brand;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.util.Arith;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.List;

/**
 * Created by Administrator on 2015/5/16.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class fillDiscountStandard extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CommodityMapper mapper;
    @Test
    public void fill() throws Exception {
        int pageCoun = 100;
        int currentPage =  192;
        Long uuid = new Long(152801);
        PageHelper.startPage(currentPage, 100);
        List<Commodity> list =  mapper.getCommodityList(null);
        PageInfo page = new PageInfo(list);
        pageCoun = page.getPages();
        DiscountStandard standard = new DiscountStandard();
        for(;currentPage < pageCoun;currentPage++){
            PageHelper.startPage(currentPage, 200);
            list =  mapper.getCommodityList(null);
            for(Commodity commodity : list){
                for(int i = 1 ; i < 5 ;   i ++){
                    standard.setMinCount(0 + ( i - 1 ) * 5 );
                    standard.setMaxCount(i * 5 - 1 );
                    standard.setCommodityid(commodity.getCommodityid());
                    standard.setPromotionstandard(i);
                    standard.setSalse(Arith.mul(commodity.getBasePrice(),1-(i-1)*0.05));
                    standard.setSalsePriceid(uuid);
                    standard.save();
                    uuid ++;
                }
            }
        }

    }
}