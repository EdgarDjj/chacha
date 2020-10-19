package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.AdminUser;

import java.util.List;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/19
 **/
public interface AdminMapper {

    AdminUser selectAdminUserByName(String name);

    List<AdminUser> getList();
}
