package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation("获取")
    @GetMapping("/getList")
    @ResponseBody
    public CommonResult<List<AdminUser>> getList() {
        return CommonResult.success(adminService.getList());
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
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AdminUser> userRegister(@RequestBody AdminUser adminUserParam) {
        AdminUser adminUser = adminService.userRegister(adminUserParam);
        System.out.println(adminUser);
        if (adminUser == null) {
            return CommonResult.failed("账号已经注册！");
        }
        return CommonResult.success(adminUser);
    }
}

