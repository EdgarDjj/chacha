package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface AdminUserMapper
{
    AdminUser selectAdminUserByName(String name);

    List<AdminUser> getList();
}
