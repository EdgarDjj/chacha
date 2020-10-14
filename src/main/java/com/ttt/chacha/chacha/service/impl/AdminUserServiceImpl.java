package com.ttt.chacha.chacha.service.impl;

import com.ttt.chacha.chacha.dao.AdminUserMapper;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.service.AdminUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService, UserDetailsService
{
    @Resource
    AdminUserMapper adminUserMapper;

    @Override
    public AdminUser selectAdminUserByName(String name)
    {
        return adminUserMapper.selectAdminUserByName(name);
    }

    @Override
    public List<AdminUser> getList() {
        return adminUserMapper.getList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        System.out.println(username);
        if(username == null || username == ""){
            throw new UsernameNotFoundException("请输入用户名!");
        }
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        AdminUser user = selectAdminUserByName(username);
        for(String s : user.getRole().split(" ")){
            s = "ROLE_" + s;
            list.add(new SimpleGrantedAuthority(s));        //由于不可能是空的(数据库中必须字段)
            System.out.println(s);
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), list);
    }
}
