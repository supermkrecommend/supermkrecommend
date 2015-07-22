package org.supermarketdiscount.server;

import org.hsqldb.User;
import org.supermarketdiscount.entity.PromotionHistory;
import org.supermarketdiscount.entity.PurchaseHistory;
import org.supermarketdiscount.entity.UserDiscount;

import java.util.Date;

/**
 * Created by admin on 2015/7/7.
 */
public class PromotionServer {
    public static final int NEARPROMOTION = 1;
    public static final int FORECASTPROMOTION = 2;
    /**
     *创建临近促销的折扣记录
     * @param discount
     * @param date
     */
    public void createNearPromotion(UserDiscount discount,Date date){
        PromotionHistory history = new PromotionHistory(discount,date,PromotionServer.NEARPROMOTION);

        history.save();
    }

    /**
     *创建预测促销的折扣记录
     * @param discount
     * @param date
     */
    public void createForecastPromotion(UserDiscount discount,Date date){
        PromotionHistory history = new PromotionHistory(discount,date,PromotionServer.FORECASTPROMOTION);
        history.save();
    }

    /**
     *进行促销回购记录，
     * 注意：可能对同一个人发送两种促销信息，即结果按照预期结果添加
     * @param purchase
     */
    public void promotionBuyBack(PurchaseHistory purchase){

    }

}
