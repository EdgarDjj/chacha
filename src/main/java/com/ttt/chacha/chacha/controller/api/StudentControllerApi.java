package com.ttt.chacha.chacha.controller.api;

import com.ttt.chacha.chacha.common.api.CommonPage;
import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.entity.SmsStudent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
@Api(tags = "学生系统")
public interface StudentControllerApi {
    @ApiOperation("学生信息查询")
    CommonResult<SmsStudent> getStudentInfo(Integer id);

    @ApiOperation("学生信息插入")
    CommonResult insertStudentInfo(SmsStudent smsStudent);

    @ApiOperation("学生信息列表")
    CommonResult<CommonPage<SmsStudent>> getStudentInfoList(Integer pageNum, Integer pageSize);

    @ApiOperation("学生信息更改")
    CommonResult updateStudentInfo(SmsStudent smsStudent);
}
