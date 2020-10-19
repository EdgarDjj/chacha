package com.ttt.chacha.chacha.controller.api;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.entity.AdminUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * Description:
 * 将接口注释代码与controller代码分离
 * @author:edgarding
 * @date:2020/10/19
 **/
@Api("后台")
public interface AdminControllerApi {

    String index();

    @ApiOperation("/登出")
    String toLogin();

    @ApiOperation("获取")
    CommonResult<List<AdminUser>> getList();

    @ApiOperation("获取验证码")
    CommonResult getAuthCode(String telephone);

    @ApiOperation("更改密码前，判断验证码是否正确")
    CommonResult updatePassword(String telephone, String authCode);

    @ApiOperation("用户注册")
    CommonResult<AdminUser> userRegister(AdminUser adminUserParam);

    @ApiOperation("账户信息更改")
    CommonResult<AdminUser> userProfile(AdminUser adminUserParam);
}
