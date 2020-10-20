package com.ttt.chacha.chacha.controller.api;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.entity.SmsStudent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
@Api("学生系统")
public interface StudentControllerApi {
    @ApiOperation("学生信息查询")
    CommonResult<SmsStudent> getStudentInfo(AdminUser user);



}
