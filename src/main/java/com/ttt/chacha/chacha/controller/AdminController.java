package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.service.AdminService;
import com.ttt.chacha.chacha.service.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/19
 **/
@Api("后台")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @GetMapping({"/","/index"})
    public String index()
    {
        return "index";
    }

    @ApiOperation("/登出")
    @GetMapping("/toLogin")
    public String toLogin()
    {
        return "login";
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return adminService.generateAuthCode(telephone);
    }

    @ApiOperation("更改密码前，判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return adminService.verifyAuthCode(telephone,authCode);
    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult userRegister() {

    }
}

