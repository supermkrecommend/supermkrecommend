package org.supermarketdiscount.Context;

import org.springframework.stereotype.Service;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.entity.UserDiscount;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/26.
 */
@Service
public class CommodityPriceContext {
    private double result;
    private long userid;
    private long commodityid;
    private EntityFactory factory;
    public void init(long userid, long commodityid){
        this.userid = userid;
        this.commodityid = commodityid;
        factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
    }
    public void interact(){

        Map map = new HashMap();
        map.put("commodityid",commodityid);
        map.put("userid",userid);
        UserDiscount userDiscount =  factory.getUserDiscount(map);
        if(userDiscount == null){
            map.put("promotionstandard",0);
            DiscountStandard standard = factory.getDiscountStandard(map);
            result = standard.getSalse();
        }else{
            result = userDiscount.getPromotionPrice();
        }
    }
    public double getResult(){
        return result;
    }
}
