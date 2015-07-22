package org.supermarketdiscount.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supermarketdiscount.dao.*;
import org.supermarketdiscount.dto.*;
import org.supermarketdiscount.entity.PromotionPrice;
import org.supermarketdiscount.entity.UserDiscount;
import org.supermarketdiscount.entity.Users;
import org.supermarketdiscount.util.BeanMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/25.
 */
@Service
public class DtoFactory {
    @Autowired
    private CommodityDtoMapper mapper;
    public List<DetailCommodityDto> getListDetailCommodityDto(Map map){
        CommodityMarkMapper commodityMarkMapper = (CommodityMarkMapper) SpringContextUtil.getBean("commodityMarkMapper");
        List<DetailCommodityDto> list = mapper.getDetailCommodityDtoList(map);
//        if(map == null){
//            map = new HashMap();
//        }
        //暂时不做商品你标签所以商品标签全为空
//        for(DetailCommodityDto dto : list){
//            map.clear();
//            map.put("ids", Arrays.asList(dto.getMarkids().split("/")));
//            dto.setMarks(commodityMarkMapper.getCommoditymarkListByIds(map));
//        }
        return list;
    }
    public List<SimpleCommodityDto> getListSimpleCommodityDto(Map map){
        return mapper.getSimpleCommodityDtoList(map);
    }
    public List<PromotionDto> getListPromotionDto(Map map){
        PromotionPriceMapper promotionPriceMapper = (PromotionPriceMapper) SpringContextUtil.getBean("promotionPriceMapper");
        List<PromotionPrice> list = promotionPriceMapper.getPromotionPriceList(map);
        List<PromotionDto> dtoList = new ArrayList<PromotionDto>();
        if(map == null){
            map = new HashMap();
        }
        for(PromotionPrice temp : list){
            PromotionDto dto = BeanMapper.map(temp,PromotionDto.class);
            map.clear();
            map.put("commodityid", dto.getPromotionid());
            dto.setCommodity(mapper.getSimpleCommodityDtoList(map).get(0));
            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<UserDiscountDto> getListUserDiscountDto(Map map){
        UserDiscountMapper userDiscountMapper = (UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper");
        CommodityTypeMapper commodityTypeMapper = (CommodityTypeMapper) SpringContextUtil.getBean("commodityTypeMapper");
        List<UserDiscount> list = userDiscountMapper.getUserDiscountList(map);
        List<UserDiscountDto> dtoList = new ArrayList<UserDiscountDto>();
        if(map == null){
            map = new HashMap();
        }
        for(UserDiscount temp : list){
            UserDiscountDto dto = BeanMapper.map(temp,UserDiscountDto.class);
            map.clear();
            map.put("commodityid", temp.getCommodityid());
            List<SimpleCommodityDto> SimpleCommoditydtolist = mapper.getSimpleCommodityDtoList(map);
            if(!SimpleCommoditydtolist.isEmpty()){
                dto.setCommodity(SimpleCommoditydtolist.get(0));
                dto.setType(commodityTypeMapper.getCommodityTypeById(temp.getTypeid()));
                dtoList.add(dto);
            }
        }
        return dtoList;
    }


    public List<UserDto> getListUserDto(Map map){
        UsersMapper usersMapper = (UsersMapper) SpringContextUtil.getBean("usersMapper");
        UserAddressMapper userAddressMapper = (UserAddressMapper) SpringContextUtil.getBean("userAddressMapper");
        List<Users> list = usersMapper.getUsersList(map);
        List<UserDto> dtoList = new ArrayList<UserDto>();
        if(map == null){
            map = new HashMap();
        }
        for(Users temp : list){
            UserDto dto = BeanMapper.map(temp,UserDto.class);
            map.clear();
            map.put("useraddressid", temp.getUseraddressid());
            //可能需要进行修改
            dto.setUserAddress(userAddressMapper.getUserAddressList(map));
            //可能需要进行修改
            dtoList.add(dto);
        }
        return dtoList;
    }
}
