package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonPage;
import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.entity.TmsTeacher;
import com.ttt.chacha.chacha.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Api(tags = "教师管理")
@RequestMapping("/teacher")
public class TeacherController
{
    @Resource
    TeacherService teacherService;

    @ApiOperation("获取教师列表")
    @GetMapping("/getTeacherList")
    @ResponseBody
    public CommonResult<CommonPage<TmsTeacher>> getTeacherList( @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize)
    {
        List<TmsTeacher> list = teacherService.getTeacherList(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("根据id获取教师")
    @GetMapping("/getTeacherById")
    @ResponseBody
    public CommonResult<TmsTeacher> getTeacherById(int id)
    {
        return null;
    }
}
