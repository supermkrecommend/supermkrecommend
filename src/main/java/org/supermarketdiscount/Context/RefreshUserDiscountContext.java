package org.supermarketdiscount.Context;

import org.springframework.stereotype.Service;
import org.supermarketdiscount.entity.DiscountCalculateTime;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.entity.UserDiscount;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.server.MessageServer;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.*;

/**
 * Created by Administrator on 2015/4/26.
 */
@Service
public class RefreshUserDiscountContext {
    private Date date;
    private EntityFactory factory;
    private Map<Long,List<Long>> sendMessage;
    public void init(Date date){
        this.date = date;
        this.factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        sendMessage = new HashMap<Long,List<Long>>();
    }
    public void interact(){
        Map map = new HashMap();
        map.put("date", date);
        List<DiscountCalculateTime> list =  factory.getListCalculateCommodity(map);
        DiscountStandard realStandard = null;
        for(DiscountCalculateTime discounttime : list){
            discounttime.setLastDate(date);
            discounttime.update();
            map.put("commodityid", discounttime.getCommodityid());
            List<UserDiscount> listdiscount = factory.getListUserDiscount(map);
            List<DiscountStandard> listStandard = factory.getListDiscountStandard(map);
            for(UserDiscount userDiscount : listdiscount){
                for(DiscountStandard standard : listStandard){
                    if((userDiscount.getSalseCount() >= standard.getMinCount())&(userDiscount.getSalseCount() <= standard.getMaxCount())){
                        realStandard = standard;
                        break;
                    }
                }
                if(realStandard.getPromotionstandard() > userDiscount.getPromotionstandard()) {
                    userDiscount.setPromotionstandard(realStandard.getPromotionstandard());
                    userDiscount.setPromotionPrice(realStandard.getSalse());
                    userDiscount.setSalseCount(0.0);
                    userDiscount.update();
                }else if(realStandard.getPromotionstandard() < userDiscount.getPromotionstandard()){
                    map.put("promotionstandard",userDiscount.getPromotionstandard() - 1);
                    realStandard = factory.getDiscountStandard(map);
                    userDiscount.setPromotionstandard(realStandard.getPromotionstandard());
                    userDiscount.setPromotionPrice(realStandard.getSalse());
                    userDiscount.setSalseCount(0.0);
                    userDiscount.update();
                }else{
                    userDiscount.setSalseCount(0.0);
                    userDiscount.update();
                }
                if( sendMessage.get(userDiscount.getUserid()) != null){
                    sendMessage.get(userDiscount.getUserid()).add(userDiscount.getCommodityid());
                }else{
                    List<Long> commodityids = new ArrayList<Long>();
                    commodityids.add(userDiscount.getCommodityid());
                    sendMessage.put(userDiscount.getUserid(),commodityids);
                }
            }
        }
        sendRefreshMessage();
    }
    public void sendRefreshMessage(){
        MessageServer server = new MessageServer();
        server.sendStandardMessage(sendMessage);
    }
    public String getResult(){
        return "SUCCESS";
    }
}
