package org.supermarketdiscount.server;

import org.supermarketdiscount.entity.*;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Administrator on 2015/6/2.
 */
public class MessageServer {
    /**
     * 发送请求用户购买短信，在购买多少则进入下一个优惠等级
     * 典型硬编码，未来一定要修改。
     */
    public void sendPromotionMessage(Date date){
        StringBuffer buffer= new StringBuffer();
        long userid = 0;
        Map map = new HashMap();
        map.put("date",date);
        EntityFactory factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        List<UserDiscount> discounts = factory.getMessageUserDiscount(map);
        if(!discounts.isEmpty()){
            if(discounts.get(0) != null){
                userid = discounts.get(0).getUserid();
                buffer.append("尊敬的顾客您好，您在本店购买的物品：").append(System.getProperty("line.separator"));
            }
            for(UserDiscount userDiscount : discounts){

                if(userid == userDiscount.getUserid()){
                    buffer.append(this.addPromotionMessage(userDiscount, factory));
                }else{
                    userid = userDiscount.getUserid();
                    buffer.append("尊敬的顾客您好，您在本店购买的物品：").append(System.getProperty("line.separator"));
                    buffer.append(this.addPromotionMessage(userDiscount, factory));
                }
            }
            WriteToFile.alterUser(buffer.toString());
        }
    }

    private StringBuffer addPromotionMessage(UserDiscount userDiscount, EntityFactory factory){
        StringBuffer buffer= new StringBuffer();
        Map map = new HashMap();
        map.clear();
        map.put("commodityid",userDiscount.getCommodityid());
        map.put("promotionstandard",userDiscount.getPromotionstandard());
        Commodity commodity = factory.getCommodity(map);
        DiscountStandard standard = factory.getDiscountStandard(map);
        DiscountCalculateTime calculateTime = factory.getDiscountCalculateTime(map);
        if(standard.getMinCount() > userDiscount.getSalseCount()){
            buffer.append(commodity.getCommodityName().trim()).append("原价：").append(commodity.getBasePrice());
            buffer.append("您的现在折扣价格为：").append(userDiscount.getPromotionPrice()).append("该专属折扣即将过期");
            buffer.append("请您在").append(calculateTime.getAlertAheadTime()).append("内，购买");
            buffer.append(standard.getMinCount() - userDiscount.getSalseCount()+1).append("件该商品，则依旧享有该专属折扣");
            buffer.append(System.getProperty("line.separator"));
        }else{
            map.put("promotionstandard",userDiscount.getPromotionstandard()+1);
            standard = factory.getDiscountStandard(map);
            if( standard != null){
                buffer.append(commodity.getCommodityName().trim()).append("原价：").append(commodity.getBasePrice());
                buffer.append("您的现在折扣为：").append(userDiscount.getPromotionPrice()).append("该专属折扣即将升级");
                buffer.append("请您在").append(calculateTime.getAlertAheadTime()).append("内，购买");
                buffer.append(standard.getMinCount() - userDiscount.getSalseCount() ).append("件该商品，您的专属折扣即将升级为");
                buffer.append(standard.getPromotionstandard()).append("级，享有现价为").append(standard.getSalse()).append("的专属优惠");
                buffer.append(System.getProperty("line.separator"));
            }else{
                buffer.append(commodity.getCommodityName()).append("已在本店享有最高优惠，欢迎您的购买");
            }
        }
        return buffer;
    }

    /**
     * 发送当前用户购买物品价格
     */
    public void sendStandardMessage(Map<Long,List<Long>> sendMessage) {
        StringBuffer buffer = new StringBuffer();
        Map map = new HashMap();
        Commodity commodity = new Commodity();
        Users user = new Users();
        UserDiscount discount = new UserDiscount();
        Set<Entry<Long ,List<Long>>> messages =  sendMessage.entrySet();
        EntityFactory factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        for(Entry<Long ,List<Long>> message : messages){
            map.clear();
            map.put("userid",message.getKey());
            user = factory.getUsers(map);
            buffer.append("尊敬的用户：").append(user.getUserid()).append("您在本店的专属折扣为：").append(System.getProperty("line.separator"));
            for(Long commodityid : message.getValue()){
                map.put("commodityid",commodityid);
                commodity = factory.getCommodity(map);
                discount = factory.getUserDiscount(map);
                buffer.append("商品：").append(commodity.getCommodityName());
                buffer.append("原价：").append(commodity.getBasePrice());
                buffer.append("的优惠价格为：").append(discount.getPromotionPrice());
                buffer.append(System.getProperty("line.separator"));
            }
            buffer.append("***************************************************").append(System.getProperty("line.separator"));
        }
        WriteToFile.sendPromotionMessage(buffer.toString());
    }

    public void forecastCommidityMessage(Date date){
        StringBuffer buffer = new StringBuffer();
        Map map = new HashMap();
        Commodity commodity = new Commodity();
        EntityFactory factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        List<UserDiscount> MessageList = factory.getforecastUserDiscount(date);
        if(!MessageList.isEmpty()){
            buffer.append("尊敬的用户，您好,我们为你推荐我们的商品：").append(System.getProperty("line.separator"));
            long userid = MessageList.get(0).getTypeid();
            for(UserDiscount discount : MessageList){
                map.put("commodityid",discount.getCommodityid());
                commodity = factory.getCommodity(map);
                if(userid == discount.getUserid()){
                   buffer.append(this.addforecastMessage(commodity, discount));
                }else{
                    buffer.append("*************************************************").append(System.getProperty("line.separator"));
                    buffer.append("尊敬的用户，您好,我们为你推荐我们的商品：").append(System.getProperty("line.separator"));
                    userid = discount.getUserid();
                    buffer.append(this.addforecastMessage(commodity, discount));
                }
            }
            WriteToFile.forecastMessage(buffer.toString());
        }
    }
    public StringBuffer addforecastMessage( Commodity commodity,UserDiscount userDiscount){
        StringBuffer buffer = new StringBuffer();
        buffer.append(commodity.getCommodityName()).append("原价");
        buffer.append(commodity.getBasePrice()).append("现价");
        buffer.append(userDiscount.getPromotionPrice()).append("欢迎您的购买").append(System.getProperty("line.separator"));
        return buffer;
    }
}
