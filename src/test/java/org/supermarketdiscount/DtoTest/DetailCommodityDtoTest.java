package org.supermarketdiscount.DtoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.CommodityDtoMapper;
import org.supermarketdiscount.dto.DetailCommodityDto;
import org.supermarketdiscount.dto.SimpleCommodityDto;
import org.supermarketdiscount.factory.EntityFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/25.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class DetailCommodityDtoTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private CommodityDtoMapper mapper;
    @Autowired
    private EntityFactory factory;
    @Test
    public void selectDetail() {
        Map map = new HashMap();
        map.put("brandid",0);
        List<DetailCommodityDto> list = mapper.getDetailCommodityDtoList(map);
        for (DetailCommodityDto dto : list) {
            System.out.println(dto.toString());
        }
    }
    @Test
    public void selectSimple() {
        Map map = new HashMap();
        map.put("brandid",0);
        List<SimpleCommodityDto> list = mapper.getSimpleCommodityDtoList(map);
        for (SimpleCommodityDto dto : list) {
            System.out.println(dto.toString());
        }
    }
}