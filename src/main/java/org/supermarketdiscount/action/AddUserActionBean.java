package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;
import org.supermarketdiscount.entity.UserAddress;
import org.supermarketdiscount.entity.Users;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/11.
 */
public class AddUserActionBean extends SupermarketActionBean {

    private Users user;
    private UserAddress delAddress;
    private UserAddress newAddress;
    @Validate(required = true, on = {"saveUser"})
    private String 用户名;
    @Validate(required = true, on = {"saveUser"})
    private String 密码;
    @Validate(required = true, on = {"saveUser", "saveAddress"}, mask = "13[0-9]{9}")
    private String 电话;
    @Validate(required = true, on = {"saveAddress"})
    private String 地址;
    @Validate(required = true, on = {"saveAddress"})
    private String 收件人;
    @Validate(required = true, on = {"saveAddress"}, mask = "^[1-9]\\d{5}$")
    private String 邮编;

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public Resolution saveUser() {
        EntityFactory entityFactory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("username", this.get用户名());
        if (entityFactory.getUsers(map) != null) {
            ValidationError error = new LocalizableError("usernameExist");
            getContext().getValidationErrors().add("username", error);
            return getContext().getSourcePageResolution();
        } else {
            user = new Users();
            user.setUsername(this.get用户名());
            user.setPassword(this.get密码());
            user.setPhoneNumber(this.get电话());
            user.save();
            return new ForwardResolution("/jsp/addUser2.jsp");
        }

    }

    public List<UserAddress> getListAddress() {
        EntityFactory entityFactory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("useraddressid", this.getUser().getUseraddressid());
        return entityFactory.getListUserAddress(map);
//        return listAddress;
    }

    public Resolution delAddress() {
        EntityFactory entityFactory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("userid", user.getUserid());
        user = entityFactory.getUsers(map);
        delAddress.del();
        return new RedirectResolution("/jsp/addUser2.jsp").flash(this);
    }

    public Resolution saveAddress() {
        UserAddress newAddress = new UserAddress();
        newAddress.setUseraddressid(user.getUseraddressid());
        newAddress.setPhoneNumber(电话);
        newAddress.setUserAddress(地址);
        newAddress.setPostcode(邮编);
        newAddress.setRecipientName(收件人);
        newAddress.save();
        newAddress = null;
        return new RedirectResolution("/jsp/addUser2.jsp").flash(this);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UserAddress getDelAddress() {
        return delAddress;
    }

    public void setDelAddress(UserAddress delAddress) {
        this.delAddress = delAddress;
    }

    public UserAddress getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(UserAddress newAddress) {
        this.newAddress = newAddress;
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

    public String get电话() {
        return 电话;
    }

    public void set电话(String 电话) {
        this.电话 = 电话;
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
}
