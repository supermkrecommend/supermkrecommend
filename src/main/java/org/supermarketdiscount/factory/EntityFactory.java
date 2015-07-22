package org.supermarketdiscount.factory;

import org.springframework.stereotype.Service;
import org.supermarketdiscount.dao.*;
import org.supermarketdiscount.entity.*;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/25.
 */
@Service
public class EntityFactory {
    public List<Brand> getListBrand(Map map) {
        return ((BrandMapper) SpringContextUtil.getBean("brandMapper")).getBrandList(map);
    }

    public Brand getBrand(Map map) {
        return ((BrandMapper) SpringContextUtil.getBean("brandMapper")).getBrand(map);
    }

    public List<Commodity> getListCommodity(Map map) {
        return ((CommodityMapper) SpringContextUtil.getBean("commodityMapper")).getCommodityList(map);
    }

    public Commodity getCommodity(Map map) {
        return ((CommodityMapper) SpringContextUtil.getBean("commodityMapper")).getCommodity(map);
    }

    public List<CommodityMark> getListCommodityMark(Map map) {
        return ((CommodityMarkMapper) SpringContextUtil.getBean("commodityMarkMapper")).getCommodityMarkList(map);
    }

    public CommodityMark getCommodityMark(Map map) {
        return ((CommodityMarkMapper) SpringContextUtil.getBean("commodityMarkMapper")).getCommodityMark(map);
    }

    public List<CommodityMark> getCommoditymarkListByIds(Map map) {
        return ((CommodityMarkMapper) SpringContextUtil.getBean("commodityMarkMapper")).getCommoditymarkListByIds(map);
    }

    public List<DiscountStandard> getListDiscountStandard(Map map) {
        return ((DiscountStandardMapper) SpringContextUtil.getBean("discountStandardMapper")).getDiscountStandardList(map);
    }

    public DiscountStandard getDiscountStandard(Map map) {
        return ((DiscountStandardMapper) SpringContextUtil.getBean("discountStandardMapper")).getDiscountStandard(map);
    }

    public List<DiscountCalculateTime> getListCalculateCommodity(Map map) {
        return ((DiscountCalculateTimeMapper) SpringContextUtil.getBean("discountCalculateTimeMapper")).getCalculateCommodityList(map);
    }

    public List<DiscountCalculateTime> getListDiscountCalculateTime(Map map) {
        return ((DiscountCalculateTimeMapper) SpringContextUtil.getBean("discountCalculateTimeMapper")).getDiscountCalculateTimeList(map);
    }

    public DiscountCalculateTime getDiscountCalculateTime(Map map) {
        return ((DiscountCalculateTimeMapper) SpringContextUtil.getBean("discountCalculateTimeMapper")).getDiscountCalculateTime(map);
    }

    public List<ProductionOrientation> getListProductionOrientation(Map map) {
        return ((ProductionOrientationMapper) SpringContextUtil.getBean("productionOrientationMapper")).getProductionOrientationList(map);
    }

    public ProductionOrientation getProductionOrientation(Map map) {
        return ((ProductionOrientationMapper) SpringContextUtil.getBean("productionOrientationMapper")).getProductionOrientation(map);
    }

    public List<PromotionPrice> getListPromotionPrice(Map map) {
        return ((PromotionPriceMapper) SpringContextUtil.getBean("promotionPriceMapper")).getPromotionPriceList(map);
    }

    public PromotionPrice getPromotionPrice(Map map) {
        return ((PromotionPriceMapper) SpringContextUtil.getBean("promotionPriceMapper")).getPromotionPrice(map);
    }

    public List<PurchaseHistory> getListPurchaseHistory(Map map) {
        return ((PurchaseHistoryMapper) SpringContextUtil.getBean("purchaseHistoryMapper")).getPurchaseHistoryList(map);
    }

    public PurchaseHistory getPurchaseHistory(Map map) {
        return ((PurchaseHistoryMapper) SpringContextUtil.getBean("purchaseHistoryMapper")).getPurchaseHistory(map);
    }

    public Double getConsumeDay(Map map){
        return ((PurchaseHistoryMapper) SpringContextUtil.getBean("purchaseHistoryMapper")).getConsumeDay(map);
    }
    public List<UserDiscount> getListUserDiscount(Map map) {
        return ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).getUserDiscountList(map);
    }
    public List<UserDiscount> getMessageUserDiscount(Map map) {
        if(map.get("date")  == null){
            return null;
        }
        return ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).getMessageUserDiscount(map);
    }
    public UserDiscount getUserDiscount(Map map) {
        return ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).getUserDiscount(map);
    }

    public List<UserDiscount> getforecastUserDiscount(Date date){
        Map map = new HashMap();
        map.put("forecastday",date);
        return ((UserDiscountMapper) SpringContextUtil.getBean("userDiscountMapper")).getforecastUserDiscount(map);
    }

    public List<Users> getListUsers(Map map) {
        return ((UsersMapper) SpringContextUtil.getBean("usersMapper")).getUsersList(map);
    }

    public Users getUsers(Map map) {
        return ((UsersMapper) SpringContextUtil.getBean("usersMapper")).getUsers(map);
    }

    public Users getUsersByUserName(String userName) {
        return ((UsersMapper) SpringContextUtil.getBean("usersMapper")).getUsersByName(userName);
    }

    public Admin getAdminByUsername(String userName) {
        return ((AdminMapper) SpringContextUtil.getBean("adminMapper")).getAdminByName(userName);
    }

    public List<UserAddress> getListUserAddress(Map map) {
        return ((UserAddressMapper) SpringContextUtil.getBean("userAddressMapper")).getUserAddressList(map);
    }

    public UserAddress getUserAddress(Map map) {
        return ((UserAddressMapper) SpringContextUtil.getBean("userAddressMapper")).getUserAddress(map);
    }
}
