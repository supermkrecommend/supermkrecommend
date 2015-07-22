package org.supermarketdiscount.server;

import org.supermarketdiscount.factory.EntityFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/13.
 */
public class PurchaseHistoryServer {
    /**
     * 计算该用户对于某一商品的购买周期
     * @param commodityid
     * @param userid
     * @return
     */
    public Double calculateConsumeDay(Long commodityid , Long userid,EntityFactory factory){
        Map map = new HashMap();
        map.put("userid",userid);
        map.put("commodityid",commodityid);
        return factory.getConsumeDay(map);
    }
}
