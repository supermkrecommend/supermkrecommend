package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.supermarketdiscount.action.biz.DiscountStandardbiz;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.entity.UserDiscount;
import org.supermarketdiscount.entity.Users;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/7.
 */
public class UpdateUserDiscountActionBean extends SupermarketActionBean {
    private Users user;
    @ValidateNestedProperties({
            @Validate(field = "commodityid", required = true, on = {"update", "updateDscount"}),
            @Validate(field = "userid", required = true, on = {"update", "updateDscount"}),
            @Validate(field = "promotionstandard", required = true, on = {"update"}),
            @Validate(field = "salseCount", required = true, on = {"updateDscount"})
    })
    private UserDiscount discount;
    private Commodity commodity;
    private DiscountStandard standard;
    private String discountStandard;
    private String targetUrl;

    public List<DiscountStandardbiz> getDiscountStandardbiz() {
        List<DiscountStandardbiz> result = new ArrayList<DiscountStandardbiz>();
        Map map = new HashMap();
        map.put("commodityid", discount.getCommodityid());
        List<DiscountStandard> list = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListDiscountStandard(map);
        for (DiscountStandard standard : list) {
            result.add(new DiscountStandardbiz(standard));
        }
        return result;
    }

    public Resolution update() {

        EntityFactory factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("userid", discount.getUserid());
        map.put("commodityid", discount.getCommodityid());
        map.put("promotionstandard", discount.getPromotionstandard());
        standard = factory.getDiscountStandard(map);
        commodity = factory.getCommodity(map);

        user = factory.getUsers(map);
        discount = factory.getUserDiscount(map);
        discountStandard = (new DiscountStandardbiz(standard)).getDiscountStandard();
        return new ForwardResolution("/jsp/updateUserDiscount.jsp");
    }

    public Resolution updateDscount() {
        EntityFactory factory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("commodityid", discount.getCommodityid());
        map.put("promotionstandard", Integer.valueOf(discountStandard.split("/")[3]));
        standard = factory.getDiscountStandard(map);
        map.clear();
        map.put("commodityid",discount.getCommodityid());
        map.put("userid", discount.getUserid());
        discount = factory.getUserDiscount(map);
        discount.changeStandard(standard);
        discount.update();
        map.put("userid", discount.getUserid());
        user = factory.getUsers(map);
//        return new ForwardResolution("/jsp/updateUserDiscount.jsp");
        return new RedirectResolution(this.targetUrl);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UserDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(UserDiscount discount) {
        this.discount = discount;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public DiscountStandard getStandard() {
        return standard;
    }

    public void setStandard(DiscountStandard standard) {
        this.standard = standard;
    }

    public String getDiscountStandard() {
        return discountStandard;
    }

    public void setDiscountStandard(String discountStandard) {
        this.discountStandard = discountStandard;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
