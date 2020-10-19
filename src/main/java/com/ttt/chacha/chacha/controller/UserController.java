package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.entity.AdminUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Api(tags = "用户管理")
@Controller
@RequestMapping("/user")
public class UserController
{

    @Autowired
    AdminUserService adminUserService;

    @GetMapping({"/","/index"})
    public String index()
    {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin()
    {
        return "login";
    }

    @ApiOperation("获取")
    @GetMapping("/getList")
    @ResponseBody
    public CommonResult<List<AdminUser>> getList() {
        return CommonResult.success(adminUserService.getList());
    }

    @ApiOperation("/通过姓名获取AdminUser")
    @GetMapping("/getUser")
    public CommonResult<AdminUser> getUserByName(@RequestParam("name") @ApiParam("姓名") String name) {
        return CommonResult.success(adminUserService.selectAdminUserByName(name));
    }
}
