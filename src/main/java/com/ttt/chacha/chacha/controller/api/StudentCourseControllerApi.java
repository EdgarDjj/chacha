package com.ttt.chacha.chacha.controller.api;

import com.ttt.chacha.chacha.common.api.CommonPage;
import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.controller.vo.StudentCourseDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
@Api(tags = "学生课表")
public interface StudentCourseControllerApi {
    @ApiOperation("学生课表查询")
    CommonResult<CommonPage<StudentCourseDetailVO>> selectStudentCourseDetailByUserId(Integer userId);
}
