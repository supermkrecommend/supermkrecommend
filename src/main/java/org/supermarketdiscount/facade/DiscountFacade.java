package org.supermarketdiscount.facade;

import org.springframework.stereotype.Service;
import org.supermarketdiscount.Context.CommodityDiscountContext;
import org.supermarketdiscount.Context.RefreshUserDiscountContext;
import org.supermarketdiscount.dto.PurchaseHistoryDto;
import org.supermarketdiscount.entity.PurchaseHistory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/26.
 */
@Service
public class DiscountFacade {
    public String CommodityDiscountCalculate(PurchaseHistory purchase)throws ParseException {
        CommodityDiscountContext context = (CommodityDiscountContext) SpringContextUtil.getBean("commodityDiscountContext");
        context.singleInit(purchase);
        context.singleInteract();
        return context.getResult();
    }
    public String refreshUserDiscount(Date date){
        RefreshUserDiscountContext context = (RefreshUserDiscountContext) SpringContextUtil.getBean("refreshUserDiscountContext");
        context.init(date);
        context.interact();
        return context.getResult();
    }
}
