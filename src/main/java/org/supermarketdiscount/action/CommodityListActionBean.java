package org.supermarketdiscount.action;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/6.
 */
public class CommodityListActionBean extends SupermarketActionBean {
    private Integer pageNum;
    private Integer pageCount;
    private Integer jumpPage;
    @ValidateNestedProperties({
            @Validate(field = "commodityid", required = true, on = {"delCommodity"})
    })
    private Commodity commodity;

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public List<Commodity> getPages() {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 20);
        List<Commodity> list = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListCommodity(null);
        PageInfo page = new PageInfo(list);
        pageCount = page.getPages();
        return list;
    }

    public Resolution getNextPage() {
        if (pageNum < pageCount) {
            pageNum++;
        }
        return new RedirectResolution("/jsp/CommodityList.jsp").flash(this);
    }

    public RedirectResolution pageJump() {
        pageNum = jumpPage;
        return new RedirectResolution("/jsp/CommodityList.jsp").flash(this);
    }

    public Resolution getLastPage() {
        if (pageNum > 1) {
            pageNum--;
        }
        return new RedirectResolution("/jsp/CommodityList.jsp").flash(this);
    }

    public List<Integer> getAllpageNum() {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= pageCount; i++) {
            result.add(i);
        }
        return result;
    }

    public Resolution delCommodity() {
        commodity.del();
        return new RedirectResolution("/jsp/CommodityList.jsp").flash(this);
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getJumpPage() {
        return jumpPage;
    }

    public void setJumpPage(Integer jumpPage) {
        this.jumpPage = jumpPage;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
