package com.ttt.chacha.chacha.config;

import com.ttt.chacha.chacha.service.impl.AdminUserServiceImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Resource
    AdminUserServiceImpl adminUserServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/").permitAll()//"/"所有角色都可以通過
                .antMatchers("/teacher/**").hasAnyRole("teacher")//"/teacher/**"只有角色為teacher才可以通過
                .antMatchers("/student/**").hasAnyRole("student")
                .antMatchers("/admin/**").hasAnyRole("admin");

//      非授权访问时跳转的方法
        http.formLogin();

//        安全
        http.csrf().disable();

//      用户注销后返回的界面
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(adminUserServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
//        静态资源放行
        web.ignoring().antMatchers("/static/**");
    }
}
