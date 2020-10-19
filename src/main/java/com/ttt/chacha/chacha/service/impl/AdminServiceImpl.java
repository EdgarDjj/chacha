package com.ttt.chacha.chacha.service.impl;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.dao.AdminMapper;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.service.AdminService;
import com.ttt.chacha.chacha.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/19
 **/
@Service
public class AdminServiceImpl implements AdminService,UserDetailsService {
    @Autowired
    private RedisService redisService;

    @Resource
    private AdminMapper adminMapper;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }


    //对输入的验证码进行校验
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }

    @Override
    public List<AdminUser> getList() {
        return adminMapper.getList();
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

    @Override
    public AdminUser selectAdminUserByName(String name)
    {
        return adminMapper.selectAdminUserByName(name);
    }

}
