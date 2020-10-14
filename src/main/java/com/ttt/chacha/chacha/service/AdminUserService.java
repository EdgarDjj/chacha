package com.ttt.chacha.chacha.service;

import com.ttt.chacha.chacha.entity.AdminUser;

public interface AdminUserService
{
    AdminUser selectAdminUserByName(String name);
}
