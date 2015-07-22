package org.supermarketdiscount.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.supermarketdiscount.dto.UserDiscountDto;
import org.supermarketdiscount.entity.UserAddress;
import org.supermarketdiscount.entity.UserDiscount;
import org.supermarketdiscount.entity.Users;
import org.supermarketdiscount.factory.DtoFactory;
import org.supermarketdiscount.factory.EntityFactory;
import org.supermarketdiscount.util.SpringContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/29.
 */
public class SingleUserActionBean extends SupermarketActionBean {
    private Users user;
    private static Integer pageNum;
    private static Integer pageSize;
    //    private List<UserAddress> listAddress;
//    private List<UserDiscountDto> userDiscounts;
    private UserAddress newAddress;
    @ValidateNestedProperties({
            @Validate(field = "addressKey", required = true, on = {"delAddress"})
    })
    private UserAddress delAddress;
    private UserDiscount delDiscount;
    private Long addressid;
    @Validate(required = true, on = {"updateUser"})
    private String 用户密码;
    @Validate(required = true, on = {"updateUser"}, mask = "13[0-9]{9}")
    private String 用户电话;
    @Validate(required = true, on = {"saveAddress"})
    private String 地址;
    @Validate(required = true, on = {"saveAddress"})
    private String 收件人;
    @Validate(required = true, on = {"saveAddress"}, mask = "13[0-9]{9}")
    private String 电话;
    @Validate(required = true, on = {"saveAddress"}, mask = "^[1-9]\\d{5}$")
    private String 邮编;

    public Users getUser() {
        return user;
    }

    public Resolution saveAddress() {
        newAddress = new UserAddress();
        newAddress.setUserAddress(this.get地址());
        newAddress.setPhoneNumber(this.get电话());
        newAddress.setRecipientName(this.get收件人());
        newAddress.setPostcode(this.get邮编());
        if (addressid == null) {
            newAddress.setUseraddressid(user.getUseraddressid());
//            Userserver server= new Userserver();
//            UserAddressMapper mapper = (UserAddressMapper) SpringContextUtil.getBean("userAddressMapper");
//            newAddress = server.getNewUserAddress(newAddress,mapper);
        } else {
            newAddress.setUseraddressid(addressid);
        }
        newAddress.save();
        return new RedirectResolution("/jsp/SingleUserEdit.jsp").flash(this);
    }

    public Resolution updateUser() {
        user.setPassword(this.get用户密码());
        user.setPhoneNumber(this.get用户电话());
        user.update();
        return new RedirectResolution("/jsp/SingleUserEdit.jsp").flash(this);
    }

    public Resolution userEdit() {
        EntityFactory entityFactory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("userid", user.getUserid());
        user = entityFactory.getUsers(map);
        return new ForwardResolution("/jsp/SingleUserEdit.jsp");
    }

    public Resolution delAddress() {
        EntityFactory entityFactory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("userid", user.getUserid());
        user = entityFactory.getUsers(map);
        delAddress.del();
        return new RedirectResolution("/jsp/SingleUserEdit.jsp").flash(this);
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public static Integer getPageNum() {
        return pageNum;
    }

    public static void setPageNum(Integer pageNum) {
        SingleUserActionBean.pageNum = pageNum;
    }

    public static Integer getPageSize() {
        return pageSize;
    }

    public static void setPageSize(Integer pageSize) {
        SingleUserActionBean.pageSize = pageSize;
    }

    public List<UserAddress> getListAddress() {
        EntityFactory entityFactory = (EntityFactory) SpringContextUtil.getBean("entityFactory");
        Map map = new HashMap();
        map.put("useraddressid", user.getUseraddressid());
        return entityFactory.getListUserAddress(map);
//        return listAddress;
    }

//    public void setListAddress(List<UserAddress> listAddress) {
//        this.listAddress = listAddress;
//    }

    public List<UserDiscountDto> getUserDiscounts() {
        DtoFactory dtoFactory = (DtoFactory) SpringContextUtil.getBean("dtoFactory");
        Map map = new HashMap();
        map.put("userid", user.getUserid());
        List<UserDiscountDto> list = dtoFactory.getListUserDiscountDto(map);
        return dtoFactory.getListUserDiscountDto(map);

//        return userDiscounts;
    }

    public UserAddress getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(UserAddress newAddress) {
        this.newAddress = newAddress;
    }

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public UserAddress getDelAddress() {
        return delAddress;
    }

    public void setDelAddress(UserAddress delAddress) {
        this.delAddress = delAddress;
    }

    public UserDiscount getDelDiscount() {
        return delDiscount;
    }

    public void setDelDiscount(UserDiscount delDiscount) {
        this.delDiscount = delDiscount;
    }

    public String get用户密码() {
        return 用户密码;
    }

    public void set用户密码(String 用户密码) {
        this.用户密码 = 用户密码;
    }

    public String get用户电话() {
        return 用户电话;
    }

    public void set用户电话(String 用户电话) {
        this.用户电话 = 用户电话;
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

    public String get电话() {
        return 电话;
    }

    public void set电话(String 电话) {
        this.电话 = 电话;
    }

    public String get邮编() {
        return 邮编;
    }

    public void set邮编(String 邮编) {
        this.邮编 = 邮编;
    }
}
