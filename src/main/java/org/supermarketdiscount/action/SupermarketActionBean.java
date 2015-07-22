package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

/**
 * Created by Administrator on 2015/4/29.
 */
public class SupermarketActionBean implements ActionBean {
    private SupermarketActionBeanContext context;

    public void setContext(ActionBeanContext context) {
        this.context = (SupermarketActionBeanContext) context;
    }

    /**
     * Gets the ActionBeanContext set by Stripes during initialization.
     */
    public SupermarketActionBeanContext getContext() {
        return this.context;
    }
}
