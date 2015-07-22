package org.supermarketdiscount.DtoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dto.DetailCommodityDto;
import org.supermarketdiscount.factory.DtoFactory;

import java.util.List;

/**
 * Created by Administrator on 2015/4/26.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class DtoFactoryTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DtoFactory factory;
    @Test
    public void getListDetailCommodityDtoTest(){
        List<DetailCommodityDto> list =  factory.getListDetailCommodityDto(null);
    }
    @Test
     public void getListPromotionDtoTest(){
        factory.getListPromotionDto(null);
    }

    @Test
     public void getListUserDiscountDtoTest(){
        factory.getListUserDiscountDto(null);
    }
    @Test
    public void getListUserDtoTest(){
        factory.getListUserDto(null);
    }
}