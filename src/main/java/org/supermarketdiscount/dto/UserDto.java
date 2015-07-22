package org.supermarketdiscount.dto;

import org.supermarketdiscount.entity.UserAddress;

import java.util.List;

/**
 * Created by Administrator on 2015/4/25.
 */
public class UserDto {
    private long userid;
    private String username;
    private List<UserAddress> userAddress;
    private String phoneNumber;
    private long membership;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    public List<UserAddress> getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(List<UserAddress> userAddress) {
        this.userAddress = userAddress;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userAddress=" + userAddress +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", membership=" + membership +
                '}';
    }
}
