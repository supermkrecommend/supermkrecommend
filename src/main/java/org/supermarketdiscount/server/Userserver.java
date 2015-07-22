package org.supermarketdiscount.server;

import org.supermarketdiscount.dao.UserAddressMapper;
import org.supermarketdiscount.dao.UsersMapper;
import org.supermarketdiscount.entity.UserAddress;
import org.supermarketdiscount.entity.Users;

/**
 * Created by Administrator on 2015/5/5.
 */
public class Userserver {
    /**
     * 用于对Users进行加工，使得只有用户名、密码、电话的User完整。
     * @param user
     * @return
     */
    public Users getNewUser(Users user,UsersMapper mapper){
        long userid = mapper.getMaxUuid();
        user.setMembership(userid);
        user.setUserid(userid);
        user.setUseraddressid(userid);
        return user;
    }
    public UserAddress getNewUserAddress(UserAddress address,UserAddressMapper mapper){
        long addressid = mapper.getMaxUuid();
        address.setUseraddressid(addressid);
        return address;
    }
}
