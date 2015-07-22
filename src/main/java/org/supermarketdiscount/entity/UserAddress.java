package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.UserAddressMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/25.
 */
public class UserAddress implements Serializable {
    private long addressKey;
    private long useraddressid;
    private String recipientName;
    private String phoneNumber;
    private String postcode;
    private String userAddress;

    public void save() {
        ((UserAddressMapper) SpringContextUtil.getBean("userAddressMapper")).add(this);
    }

    public void del() {
        ((UserAddressMapper) SpringContextUtil.getBean("userAddressMapper")).del(this);
    }

    public void update() {
        ((UserAddressMapper) SpringContextUtil.getBean("userAddressMapper")).update(this);
    }

    public long getAddressKey() {
        return addressKey;
    }

    public void setAddressKey(long addressKey) {
        this.addressKey = addressKey;
    }


    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public long getUseraddressid() {
        return useraddressid;
    }

    public void setUseraddressid(long useraddressid) {
        this.useraddressid = useraddressid;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
