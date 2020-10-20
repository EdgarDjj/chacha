package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonPage;
import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.controller.api.TeacherControllerApi;
import com.ttt.chacha.chacha.entity.TmsTeacher;
import com.ttt.chacha.chacha.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController implements TeacherControllerApi
{
    @Resource
    private TeacherService teacherService;

    @Override
    @GetMapping("/getTeacherList")
    @ResponseBody
    public CommonResult<CommonPage<TmsTeacher>> getTeacherList( @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize)
    {
        List<TmsTeacher> list = teacherService.getTeacherList(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @Override
    @PostMapping("/updateTeacher")
    @ResponseBody
    public CommonResult updateTeacher(@RequestBody TmsTeacher tmsTeacher)
    {
        int flag = teacherService.updateTeacher(tmsTeacher);
        System.out.println(flag);
        if (flag > 0)
            return CommonResult.success(flag, "教师修改成功");
        else
            return CommonResult.failed();
    }

    @Override
    @GetMapping("/deleteTeacherById")
    @ResponseBody
    public CommonResult deleteTeacherById(TmsTeacher tmsTeacher)
    {
        int flag = teacherService.deleteTeacherById(tmsTeacher);
        if (flag > 0)
            return CommonResult.success(flag,"教师删除成功");
        else
            return CommonResult.failed();
    }

    @Override
    @PostMapping
    @ResponseBody
    public CommonResult addTeacher(@RequestBody TmsTeacher tmsTeacher)
    {
        int flag = teacherService.addTeacher(tmsTeacher);
        if (flag > 0)
            return CommonResult.success(flag,"教师添加成功");
        else
            return CommonResult.failed();
    }

    @Override
    @PostMapping("/selectTeacherByUserId")
    @ResponseBody
    public CommonResult<TmsTeacher> selectTeacherByUserId(@RequestBody TmsTeacher tmsTeacher)
    {
        TmsTeacher teacher = teacherService.selectTeacherByUserId(tmsTeacher);
        if (teacher != null)
        return CommonResult.success(teacher,"获取教师对象成功");
        else
            return CommonResult.failed("教室查询失败");
    }

}
