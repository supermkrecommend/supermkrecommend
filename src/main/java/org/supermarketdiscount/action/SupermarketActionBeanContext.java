package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ActionBeanContext;
import org.supermarketdiscount.entity.Admin;
import org.supermarketdiscount.entity.Users;

/**
 * Created by Administrator on 2015/4/29.
 */
public class SupermarketActionBeanContext extends ActionBeanContext {
    /**
     * Gets the currently logged in user, or null if no-one is logged in.
     */
    public Admin getUser() {
        return (Admin) getRequest().getSession().getAttribute("admin");
    }

    /**
     * Sets the currently logged in user.
     */
    public void setUser(Admin currentUser) {
        getRequest().getSession().setAttribute("admin", currentUser);
    }

    /**
     * Logs the user out by invalidating the session.
     */
    public void logout() {
        getRequest().getSession().invalidate();
    }
}
