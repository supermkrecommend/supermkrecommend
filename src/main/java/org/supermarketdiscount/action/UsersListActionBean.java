package org.supermarketdiscount.action;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.supermarketdiscount.entity.Users;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/29.
 */
public class UsersListActionBean extends SupermarketActionBean {
    private Integer pageNum;
    private Integer pageCount;
    private Integer jumpPage;
    @ValidateNestedProperties({
            @Validate(field = "userid", required = true, on = {"delUser"})
    })
    private Users user;

    public List<Users> getPages() {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 20);
        List<Users> list = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getListUsers(null);
        PageInfo page = new PageInfo(list);
        pageCount = page.getPages();
        return list;
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public Resolution getNextPage() {
        if (pageNum < pageCount) {
            pageNum++;
        }
        return new RedirectResolution("/jsp/usersList.jsp").flash(this);
    }

    public RedirectResolution pageJump() {
        pageNum = jumpPage;
        return new RedirectResolution("/jsp/usersList.jsp").flash(this);
    }

    public Resolution getLastPage() {
        if (pageNum > 1) {
            pageNum--;
        }
        return new RedirectResolution("/jsp/usersList.jsp").flash(this);
    }

    public List<Integer> getAllpageNum() {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= pageCount; i++) {
            result.add(i);
        }
        return result;
    }

    public Resolution delUser() {
        //是否进行购物记录，折扣记录的删除
        user.del();
        return new RedirectResolution("/jsp/usersList.jsp").flash(this);
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


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
