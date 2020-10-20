package com.ttt.chacha.chacha.controller.api;

import com.ttt.chacha.chacha.common.api.CommonPage;
import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.entity.TmsTeacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
@Api(tags = "教师管理")
public interface TeacherControllerApi {

    @ApiOperation("获取教师列表")
    CommonResult<CommonPage<TmsTeacher>> getTeacherList(Integer pageNum, Integer pageSize);

    @ApiOperation("修改教师")
    CommonResult updateTeacher(TmsTeacher tmsTeacher);

    @ApiOperation("通过id删除教师")
    CommonResult deleteTeacherById(TmsTeacher tmsTeacher);

    @ApiOperation("添加教师")
    CommonResult addTeacher(TmsTeacher tmsTeacher);

    @ApiOperation("根据userId查询教师")
    CommonResult<TmsTeacher> selectTeacherByUserId(TmsTeacher tmsTeacher);
}
