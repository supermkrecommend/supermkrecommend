package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;
import org.supermarketdiscount.action.biz.QuickSalebiz;
import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.entity.DiscountCalculateTime;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.DateGenerator;
import org.supermarketdiscount.util.SpringContextUtil;

import java.text.ParseException;
import java.util.*;

/**
 * Created by Administrator on 2015/5/7.
 */
public class AddCommodityActionBean extends SupermarketActionBean {

    @Validate(required = true, on = {"add"})
    private String 商品名称;
    @Validate(required = true, on = {"add"})
    private String 商品规格;
    @Validate(required = true, on = {"add"})
    private String 产品产地;
    @Validate(required = true, on = {"add"})
    private Double 产品价格;
    @Validate(required = true, on = {"add"})
    private boolean 是否快消;
    @Validate(required = true, on = {"add"})
    private Integer 统计间隔时间;
    @Validate(required = true, on = {"add"})
    private Double 预估使用天数;
    @Validate(required = true, on = {"add"})
    private Integer 提前通知天数;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 折扣等级;
    @Validate(required = true, on = {"saveDiscount"})
    private Double 优惠价格;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 周期最小购买数;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 周期最大购买数;
    @Validate(required = true, on = {"saveDiscount"})
    private Integer 提前通知数量;
    private Commodity commodity;
    private DiscountStandard standard;
    private DiscountCalculateTime calculateTime;

    public Resolution addCommodity() {
        return new ForwardResolution("/jsp/addCommodity.jsp");
    }

    public Resolution add() throws ParseException {
        long commodityid = ((CommodityMapper) SpringContextUtil.getBean("commodityMapper")).getMaxUuid();
        commodity = new Commodity();
        calculateTime = new DiscountCalculateTime();
        calculateTime.setCommodityid(commodity.getCommodityid());
        calculateTime.setSpaceTime(this.get统计间隔时间());
        calculateTime.setLastDate(DateGenerator.toDatetime(new Date()));
        calculateTime.setAlertAheadTime(this.get提前通知天数());
        commodity.setCommodityid(commodityid);
        commodity.setQualification(this.get商品规格());
        commodity.setBasePrice(this.get产品价格());
        commodity.setIsquickSale(this.getIs是否快消());
        commodity.setManufacture(this.get产品产地());
        commodity.setConsumeday(this.get预估使用天数());
        commodity.setCommodityName(this.get商品名称());
        commodity.save();
        return new ForwardResolution("/jsp/addCommodity2.jsp");
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public List<DiscountStandard> getDiscountStandard() {
        Map map = new HashMap();
        map.put("commodityid", commodity.getCommodityid());
        return ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListDiscountStandard(map);
    }

    public Resolution saveDiscount() {
        standard.setSalse(this.get优惠价格());
        standard.setPromotionstandard(this.get折扣等级());
        standard.setMaxCount(this.get周期最大购买数());
        standard.setMinCount(this.get周期最小购买数());
        standard.setAlterAmount(this.get提前通知数量());
        commodity.setCommodityid(standard.getCommodityid());
        Map map = new HashMap();
        map.put("commodityid", standard.getCommodityid());
        map.put("promotionstandard", standard.getPromotionstandard());
        List<DiscountStandard> list = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListDiscountStandard(map);
        if (!list.isEmpty()) {
            ValidationError error = new LocalizableError("promotionstandardExist");
            getContext().getValidationErrors().add("promotionstandard", error);
            return getContext().getSourcePageResolution();
        } else {
            standard.save();
        }

        return new RedirectResolution("/jsp/addCommodity2.jsp").flash(this);
    }

    public List<QuickSalebiz> getQuickSalebiz() {
        List<QuickSalebiz> result = new ArrayList<QuickSalebiz>();
        result.add(new QuickSalebiz(false));
        result.add(new QuickSalebiz(true));
        return result;
    }

    public String get商品名称() {
        return 商品名称;
    }

    public void set商品名称(String 商品名称) {
        this.商品名称 = 商品名称;
    }

    public String get商品规格() {
        return 商品规格;
    }

    public void set商品规格(String 商品规格) {
        this.商品规格 = 商品规格;
    }

    public String get产品产地() {
        return 产品产地;
    }

    public void set产品产地(String 产品产地) {
        this.产品产地 = 产品产地;
    }

    public Double get产品价格() {
        return 产品价格;
    }

    public void set产品价格(Double 产品价格) {
        this.产品价格 = 产品价格;
    }

    public boolean getIs是否快消() {
        return 是否快消;
    }

    public void set是否快消(boolean 是否快消) {
        this.是否快消 = 是否快消;
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

    public boolean is是否快消() {
        return 是否快消;
    }

    public Integer get折扣等级() {
        return 折扣等级;
    }

    public void set折扣等级(Integer 折扣等级) {
        this.折扣等级 = 折扣等级;
    }

    public Double get优惠价格() {
        return 优惠价格;
    }

    public void set优惠价格(Double 优惠价格) {
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

    public Integer get统计间隔时间() {
        return 统计间隔时间;
    }

    public void set统计间隔时间(Integer 统计间隔时间) {
        this.统计间隔时间 = 统计间隔时间;
    }

    public DiscountCalculateTime getCalculateTime() {
        return calculateTime;
    }

    public void setCalculateTime(DiscountCalculateTime calculateTime) {
        this.calculateTime = calculateTime;
    }

    public Integer get提前通知天数() {
        return 提前通知天数;
    }

    public void set提前通知天数(Integer 提前通知天数) {
        this.提前通知天数 = 提前通知天数;
    }

    public Integer get提前通知数量() {
        return 提前通知数量;
    }

    public void set提前通知数量(Integer 提前通知数量) {
        this.提前通知数量 = 提前通知数量;
    }

    public Double get预估使用天数() {
        return 预估使用天数;
    }

    public void set预估使用天数(Double 预估使用天数) {
        this.预估使用天数 = 预估使用天数;
    }
}
