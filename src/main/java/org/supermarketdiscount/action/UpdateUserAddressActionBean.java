package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import org.supermarketdiscount.entity.UserAddress;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/6.
 */
public class UpdateUserAddressActionBean extends SupermarketActionBean {
    private UserAddress address;
    @Validate(required = true, on = {"update"})
    private String 地址;
    @Validate(required = true, on = {"update"})
    private String 收件人;
    @Validate(required = true, on = {"update"})
    private String 邮编;
    @Validate(required = true, on = {"update"}, mask = "13[0-9]{9}")
    private String 电话;
    private String targetUrl;

    public Resolution updateAddress() {
        EntityFactory entityFactory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("addressKey", address.getAddressKey());
        address = entityFactory.getUserAddress(map);
        return new ForwardResolution("/jsp/updateUserAddress.jsp");
    }

    public Resolution update() {
        address.setRecipientName(this.get收件人());
        address.setPostcode(this.get邮编());
        address.setPhoneNumber(this.get电话());
        address.setUserAddress(this.get地址());
        address.update();
//        return  new RedirectResolution("/jsp/updateUserAddress.jsp").flash(this);
        return new RedirectResolution(this.targetUrl);
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public String get地址() {
        return 地址;
    }

    public void set地址(String 地址) {
        this.地址 = 地址;
    }

    public String get收件人() {
        return 收件人;
    }

    public void set收件人(String 收件人) {
        this.收件人 = 收件人;
    }

    public String get邮编() {
        return 邮编;
    }

    public void set邮编(String 邮编) {
        this.邮编 = 邮编;
    }

    public String get电话() {
        return 电话;
    }

    public void set电话(String 电话) {
        this.电话 = 电话;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

}
