package org.supermarketdiscount.entity;

import org.supermarketdiscount.dao.UsersMapper;
import org.supermarketdiscount.util.SpringContextUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/24.
 */
public class Users implements Serializable {
    private long userid;
    private String username;
    private String password;
    private long useraddressid;
    private String phoneNumber;
    private long membership;

    public void save() {
        UsersMapper mapper = (UsersMapper) SpringContextUtil.getBean("usersMapper");
        mapper.add(this);
        this.setUseraddressid(this.getUserid());
        this.setMembership(this.getUserid());
        mapper.update(this);
    }

    public void del() {
        ((UsersMapper) SpringContextUtil.getBean("usersMapper")).del(this);
        UserDiscount userDiscount = new UserDiscount();
        userDiscount.setUserid(this.getUserid());
        userDiscount.delByuserid();;
    }

    public void update() {
        ((UsersMapper) SpringContextUtil.getBean("usersMapper")).update(this);
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getMembership() {
        return membership;
    }

    public void setMembership(long membership) {
        this.membership = membership;
    }

    public long getUseraddressid() {
        return useraddressid;
    }

    public void setUseraddressid(long useraddressid) {
        this.useraddressid = useraddressid;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", useraddressid=" + useraddressid +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", membership=" + membership +
                '}';
    }
}
