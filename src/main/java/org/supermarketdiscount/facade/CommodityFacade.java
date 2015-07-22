package org.supermarketdiscount.facade;

import org.springframework.stereotype.Service;
import org.supermarketdiscount.Context.CommodityPriceContext;
import org.supermarketdiscount.util.SpringContextUtil;

/**
 * Created by Administrator on 2015/4/26.
 */
@Service
public class CommodityFacade {
    public double getCommodityPrice(long userid, long commodityid){
        CommodityPriceContext context = (CommodityPriceContext) SpringContextUtil.getBean("commodityPriceContext");
        context.init(userid,commodityid);
        context.interact();
        return context.getResult();
    }
}
