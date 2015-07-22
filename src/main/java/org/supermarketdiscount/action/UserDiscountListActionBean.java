package org.supermarketdiscount.action;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.supermarketdiscount.entity.UserDiscount;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/11.
 */
public class UserDiscountListActionBean extends SupermarketActionBean {
    private Integer pageNum;
    private Integer pageCount;
    private Integer jumpPage;
    private UserDiscount userDiscount;
    @ValidateNestedProperties({
            @Validate(field = "userid", required = true, on = {"delUserDiscount"}),
            @Validate(field = "commodityid", required = true, on = {"delUserDiscount"})
    })
    private UserDiscount delUserDiscount;

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public Resolution userDiscountList() {
        return new ForwardResolution("/jsp/userDiscountList.jsp");
    }

    public List<UserDiscount> getUserDiscountlist() {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 20);
        Map map = new HashMap();
        if (userDiscount.getUserid() != 0) {
            map.put("userid", userDiscount.getUserid());
        }
        if (userDiscount.getCommodityid() != 0) {
            map.put("commodityid", userDiscount.getCommodityid());
        }
        List<UserDiscount> result = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListUserDiscount(map);
        PageInfo page = new PageInfo(result);
        pageCount = page.getPages();
        return result;
    }

    public Resolution getNextPage() {
        if (pageNum < pageCount) {
            pageNum++;
        }
        return new RedirectResolution("/jsp/userDiscountList.jsp").flash(this);
    }

    public RedirectResolution pageJump() {
        pageNum = jumpPage;
        return new RedirectResolution("/jsp/userDiscountList.jsp").flash(this);
    }

    public Resolution getLastPage() {
        if (pageNum > 1) {
            pageNum--;
        }
        return new RedirectResolution("/jsp/userDiscountList.jsp").flash(this);
    }

    public List<Integer> getAllpageNum() {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= pageCount; i++) {
            result.add(i);
        }
        return result;
    }

    public Resolution delUserDiscount() {
        delUserDiscount.del();
        return new RedirectResolution("/jsp/userDiscountList.jsp").flash(this);
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

    public void setUserDiscount(UserDiscount userDiscount) {
        this.userDiscount = userDiscount;
    }

    public UserDiscount getDelUserDiscount() {
        return delUserDiscount;
    }

    public void setDelUserDiscount(UserDiscount delUserDiscount) {
        this.delUserDiscount = delUserDiscount;
    }


    public UserDiscount getUserDiscount() {
        return userDiscount;
    }
}
