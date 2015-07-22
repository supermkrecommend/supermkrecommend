package org.supermarketdiscount.dao;

import org.supermarketdiscount.entity.Admin;
import org.supermarketdiscount.entity.Brand;
import org.supermarketdiscount.entity.Users;

import java.util.Map;

/**
 * Created by Administrator on 2015/6/2.
 */
public interface AdminMapper {
    Admin getAdmin(Map map);

    Admin getAdminByName(String userName);

    void add(Admin admin);
}
