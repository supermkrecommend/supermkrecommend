package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;
import org.supermarketdiscount.entity.Admin;
import org.supermarketdiscount.entity.Users;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

/**
 * Created by Administrator on 2015/4/29.
 */
public class LoginActionBean extends SupermarketActionBean {
    @Validate(required = true)
    private String 用户名;

    @Validate(required = true)
    private String 密码;

    private String targetUrl;


    /**
     * The URL the user was trying to access (null if the login page was accessed directly).
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * The URL the user was trying to access (null if the login page was accessed directly).
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Resolution login() {
        Admin admin = ((EntityFactory) SpringContextUtil.getBean("entityFactory")).getAdminByUsername(this.get用户名().trim());
        if (admin == null) {
            ValidationError error = new LocalizableError("usernameDoesNotExist");
            getContext().getValidationErrors().add("用户名", error);
            return getContext().getSourcePageResolution();
        } else if (!admin.getPassword().equals(this.get密码().trim())) {
            ValidationError error = new LocalizableError("incorrectPassword");
            getContext().getValidationErrors().add("密码", error);
            return getContext().getSourcePageResolution();
        } else {
            getContext().setUser(admin);
            if (this.targetUrl != null) {
                return new RedirectResolution(this.targetUrl);
            } else {
                return new RedirectResolution("/jsp/usersList.jsp");
            }
        }
    }

    public String get用户名() {
        return 用户名;
    }

    public void set用户名(String 用户名) {
        this.用户名 = 用户名;
    }

    public String get密码() {
        return 密码;
    }

    public void set密码(String 密码) {
        this.密码 = 密码;
    }
}
