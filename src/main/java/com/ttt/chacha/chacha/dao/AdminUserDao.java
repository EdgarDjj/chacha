package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserDao
{
    AdminUser selectAdminUserByName(String name);
}
