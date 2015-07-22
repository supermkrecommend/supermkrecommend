package org.supermarketdiscount.server;

import org.supermarketdiscount.dao.PurchaseHistoryMapper;
import org.supermarketdiscount.dao.UserDiscountMapper;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.entity.PurchaseHistory;
import org.supermarketdiscount.entity.SalseDayAccount;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.Arith;
import org.supermarketdiscount.util.DateGenerator;
import org.supermarketdiscount.util.SpringContextUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/7/7.
 */
public class DayAccountServer {
    /**
     * 执行顺序：
     * 查询单填销售的所有商品的种类，
     * 按照商品进行统计，结果再存入数据库
     * 不能使用数据库执行相加，因为有double，会出现错误。
     * @param date
     * @throws ParseException
     */
    public void dayAcconut(Date date) throws ParseException {
        date = DateGenerator.toDate(date);
        PurchaseHistoryMapper purchaseHistoryMapper = (PurchaseHistoryMapper) SpringContextUtil.getBean("purchaseHistoryMapper");
        EntityFactory factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        /**
         * 通过购物记录查询销售的商品类别
         */
        Map map = new HashMap();
        map.put("date", date);
        Commodity commodity = null;
        SalseDayAccount account = null;
        List<Long> commodityids = purchaseHistoryMapper.getDistinctCommodityid(map);
        for(Long commodityid : commodityids){
            account = new SalseDayAccount();
            account.setCommodityid(commodityid);
            account.setPurchaseDate(date);
            map.clear();
            map.put("commodityid", commodityid);
            commodity = factory.getCommodity(map);
            for(PurchaseHistory history : factory.getListPurchaseHistory(map)){
                account.setSalseCount(Arith.add(account.getSalseCount(),history.getCounts()));
                account.setProfit(Arith.add(account.getProfit(),history.getCountPrice()));
            }
            account.setProfit(Arith.sub(account.getProfit(),Arith.mul(commodity.getCostPrice(),account.getSalseCount())));
            account.save();
        }

    }
}
