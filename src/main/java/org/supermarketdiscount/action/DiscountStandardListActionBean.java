package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationError;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/11.
 */
public class DiscountStandardListActionBean extends SupermarketActionBean {

    private Commodity commodity;
    @ValidateNestedProperties({
            @Validate(field = "commodityid", required = true, on = {"delDiscountStandard"})
    })
    private DiscountStandard delStandard;
    private DiscountStandard standard;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 折扣等级;
    @Validate(required = true, on = {"saveDiscount"})
    private double 优惠价格;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 周期最小购买数;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 周期最大购买数;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 提前通知数量;

    public Resolution standardList() {
        Map map = new HashMap();
        map.put("commodityid", commodity.getCommodityid());
        commodity = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getCommodity(map);
        return new ForwardResolution("/jsp/discountStandardList.jsp");
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public List<DiscountStandard> getDiscountStandard() {
        Map map = new HashMap();
        map.put("commodityid", commodity.getCommodityid());
        return ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListDiscountStandard(map);
    }

    public Resolution delDiscountStandard() {
        Map map = new HashMap();
        map.put("commodityid", delStandard.getCommodityid());
        commodity = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getCommodity(map);
        delStandard.del();
        return new RedirectResolution("/jsp/discountStandardList.jsp").flash(this);
    }

    public Resolution saveDiscount() {
        Map map = new HashMap();
        standard.setSalse(this.get优惠价格());
        standard.setPromotionstandard(this.get折扣等级());
        standard.setMinCount(this.get周期最小购买数());
        standard.setMaxCount(this.get周期最大购买数());
        standard.setAlterAmount(this.get提前通知数量());
        map.put("commodityid", standard.getCommodityid());
        map.put("promotionstandard", standard.getPromotionstandard());
        List<DiscountStandard> list = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListDiscountStandard(map);
        commodity = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getCommodity(map);
        if (!list.isEmpty()) {
            ValidationError error = new LocalizableError("promotionstandardExist");
            getContext().getValidationErrors().add("promotionstandard", error);
            return getContext().getSourcePageResolution();
        } else {
            standard.save();
        }
        standard = null;
        return new RedirectResolution("/jsp/discountStandardList.jsp").flash(this);
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public DiscountStandard getDelStandard() {
        return delStandard;
    }

    public void setDelStandard(DiscountStandard delStandard) {
        this.delStandard = delStandard;
    }

    public DiscountStandard getStandard() {
        return standard;
    }

    public void setStandard(DiscountStandard standard) {
        this.standard = standard;
    }

    public Integer get折扣等级() {
        return 折扣等级;
    }

    public void set折扣等级(Integer 折扣等级) {
        this.折扣等级 = 折扣等级;
    }

    public double get优惠价格() {
        return 优惠价格;
    }

    public void set优惠价格(double 优惠价格) {
        this.优惠价格 = 优惠价格;
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

    public Integer get提前通知数量() {
        return 提前通知数量;
    }

    public void set提前通知数量(Integer 提前通知数量) {
        this.提前通知数量 = 提前通知数量;
    }
}
