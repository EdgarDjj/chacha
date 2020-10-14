package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface AdminUserDao
{
    AdminUser selectAdminUserByName(String name);

    List<AdminUser> getList();

    AdminUser getUserByName(String name);
}
