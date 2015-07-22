package org.supermarketdiscount.Context;

import org.springframework.stereotype.Service;
import org.supermarketdiscount.dto.PurchaseHistoryDto;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.entity.PromotionPrice;
import org.supermarketdiscount.entity.PurchaseHistory;
import org.supermarketdiscount.entity.UserDiscount;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.server.PurchaseHistoryServer;
import org.supermarketdiscount.util.Arith;
import org.supermarketdiscount.util.BeanMapper;
import org.supermarketdiscount.util.DateGenerator;
import org.supermarketdiscount.util.SpringContextUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/26.
 */
@Service
public class CommodityDiscountContext {
    private EntityFactory factory;
    private PurchaseHistoryServer server;
    private PurchaseHistory purchase;
    public void singleInit(PurchaseHistory purchase){
        this.purchase = purchase;
        factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
    }
    public void singleInteract() throws ParseException{
        BeanMapper.map(purchase,PurchaseHistory.class).save();
        Map map = new HashMap();
        map.put("commodityid",purchase.getCommodityid());
        map.put("userid", purchase.getUserid());
        UserDiscount userdiscount =  factory.getUserDiscount(map);
        if(userdiscount == null){
            UserDiscount discount = new UserDiscount();
            discount.setSalseCount(purchase.getCounts());
            discount.setUserid(purchase.getUserid());
            discount.setTotalcount(purchase.getCounts());
            discount.setConsumeday(factory.getCommodity(map).getConsumeday());
            discount.setNextpruchasetime(this.calculateNextPurchaseDate(purchase.getShortDate(),discount.getConsumeday(),purchase.getCounts()));
//            discount.setTypeid(factory.getCommodity(map).getTypeid());
             discount.setCommodityid(purchase.getCommodityid());
            map.put("promotionstandard", 1);
            DiscountStandard standard =  factory.getDiscountStandard(map);
            discount.setPromotionPrice(standard.getSalse());
            discount.setPromotionstandard(1);
            discount.save();
        }else{
            UserDiscount discount = userdiscount;
            discount.setSalseCount(Arith.add(discount.getSalseCount(),purchase.getCounts()));
            discount.setTotalcount(Arith.add(discount.getTotalcount(),purchase.getCounts()));
            discount.setNextpruchasetime(this.calculateNextPurchaseDate(purchase.getShortDate(),discount.getConsumeday(),purchase.getCounts()));
            //使用了硬编码，尤其没有针对每一个商品这顶多个计算周期阈值，未来需要重构
            if(discount.getTotalcount() == 15){
                discount.setConsumeday(server.calculateConsumeDay(discount.getCommodityid(), discount.getUserid(),factory));
            }
            discount.update();
        }
    }
    private Date calculateNextPurchaseDate(Date currentDate , Double consumeDay,Double count) throws ParseException {
        return  DateGenerator.toDate(DateGenerator.getDateBefore(currentDate, -Arith.doubleFloor(Arith.mul(consumeDay, count))));
    }
    public String getResult(){
        return "SUCCESS";
    }
}
