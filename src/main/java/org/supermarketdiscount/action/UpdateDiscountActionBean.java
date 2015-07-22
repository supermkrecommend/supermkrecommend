package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import org.supermarketdiscount.dao.DiscountStandardMapper;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/6.
 */
public class UpdateDiscountActionBean extends SupermarketActionBean {
    public DiscountStandard discount;
    @Validate(required = true, on = {"update"})
    private Double 优惠价格;
    @Validate(required = true, on = {"update"})
    private Integer 周期最小购买数;
    @Validate(required = true, on = {"update"})
    private Integer 周期最大购买数;
    @Validate(required = true, on = {"update"})
    private Integer 提前通知数量;
    private String targetUrl;

    public Resolution updateDiscount() {
        Map map = new HashMap();
        map.put("salsePriceid", discount.getSalsePriceid());
        discount = ((DiscountStandardMapper) SpringContextUtil.getBean("discountStandardMapper")).getDiscountStandard(map);
        return new ForwardResolution("/jsp/updateDiscountStandard.jsp");
    }

    public Resolution update() {
        discount.setSalsePriceid(discount.getSalsePriceid());
        discount.setMaxCount(this.get周期最大购买数());
        discount.setMinCount(this.get周期最小购买数());
        discount.setSalse(this.get优惠价格());
        discount.setAlterAmount(this.get提前通知数量());
        discount.update();
        return new RedirectResolution(this.targetUrl);
    }

    public DiscountStandard getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStandard discount) {
        this.discount = discount;
    }

    public Integer get周期最小购买数() {
        return 周期最小购买数;
    }

    public void set周期最小购买数(Integer 周期最小购买数) {
        this.周期最小购买数 = 周期最小购买数;
    }

    public Integer get周期最大购买数() {
        return 周期最大购买数;
    }

    public void set周期最大购买数(Integer 周期最大购买数) {
        this.周期最大购买数 = 周期最大购买数;
    }

    public double get优惠价格() {

        return 优惠价格;
    }

    public void set优惠价格(double 优惠价格) {
        this.优惠价格 = 优惠价格;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public void set优惠价格(Double 优惠价格) {
        this.优惠价格 = 优惠价格;
    }

    public Integer get提前通知数量() {
        return 提前通知数量;
    }

    public void set提前通知数量(Integer 提前通知数量) {
        this.提前通知数量 = 提前通知数量;
    }

}
