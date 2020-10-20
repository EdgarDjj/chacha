package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.controller.api.AdminControllerApi;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/19
 **/

@Controller
@RequestMapping("/admin")
public class AdminController implements AdminControllerApi {
    @Resource
    AdminService adminService;

    @Override
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }


    @Override
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    @Override
    @GetMapping("/getList")
    @ResponseBody
    public CommonResult<List<AdminUser>> getList() {
        return CommonResult.success(adminService.getList());
    }


    @Override
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return adminService.generateAuthCode(telephone);
    }


    @Override
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return adminService.verifyAuthCode(telephone, authCode);
    }


    @Override
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AdminUser> userRegister(@RequestBody AdminUser adminUserParam) {
        AdminUser adminUser = adminService.userRegister(adminUserParam);
        if (adminUser == null) {
            return CommonResult.failed("账号已经注册！");
        }
        return CommonResult.success(adminUser);
    }


    @Override
    @RequestMapping(value = "/userProfile", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AdminUser> userProfile(@RequestBody AdminUser adminUserParam) {
        AdminUser adminUser = adminService.userProfile(adminUserParam);
        if (adminUser != null) {
            return CommonResult.success(adminUser);
        } else {
            return CommonResult.failed("修改失败！");
        }
    }

}
