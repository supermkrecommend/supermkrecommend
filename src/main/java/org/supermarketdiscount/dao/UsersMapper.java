package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.Users;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/24.
 */
public interface UsersMapper {
    List<Users> getUsersList(Map map);

    Users getUsers(Map map);

    Users getUsersByName(String userName);

    long getMaxUuid();

    long add(Users users);

    void update(Users users);

    void del(Users users);
}
