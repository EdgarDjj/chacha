package com.ttt.chacha.chacha.service;

import com.ttt.chacha.chacha.entity.AdminUser;

import java.util.List;

public interface AdminUserService
{
    AdminUser selectAdminUserByName(String name);

    List<AdminUser> getList();
}
