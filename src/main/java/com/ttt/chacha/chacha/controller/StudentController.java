package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonPage;
import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.controller.api.StudentControllerApi;
import com.ttt.chacha.chacha.entity.SmsStudent;
import com.ttt.chacha.chacha.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * 学生信息
 * @author:edgarding
 * @date:2020/10/20
 **/
@Controller
@RequestMapping("/student")
public class StudentController implements StudentControllerApi {

    @Resource
    StudentService studentService;

    @Override
    @GetMapping("/getStudent")
    public CommonResult<SmsStudent> getStudentInfo(@Param("userId") Integer userId) {
        SmsStudent student = studentService.selectStudentByUserId(userId);
        if (student == null) {
            return CommonResult.failed("查询失败！");
        }
        return CommonResult.success(student);
    }

    @Override
    @PostMapping("/insertStudentInfo")
    @ResponseBody
    public CommonResult insertStudentInfo(@RequestBody SmsStudent smsStudent) {
        boolean isSuccess = studentService.insertStudentInfo(smsStudent);
        if(!isSuccess) {
            return CommonResult.failed("插入学生信息失败，已存在！");
        }
        return CommonResult.success("插入成功");
    }

    @Override
    @PostMapping("/getStudentInfoList")
    @ResponseBody
    public CommonResult<CommonPage<SmsStudent>> getStudentInfoList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<SmsStudent> list = studentService.getStudentInfoList(pageNum, pageSize);
        if (list.isEmpty()) {
            return CommonResult.failed("没有数据！");
        }
        return CommonResult.success(CommonPage.restPage(list));
    }

    @Override
    @PostMapping("/updateStudentInfo")
    @ResponseBody
    public CommonResult updateStudentInfo(@RequestBody SmsStudent smsStudent) {
        studentService.updateStudentInfo(smsStudent);
        return CommonResult.success("修改成功！");
    }

    @Override
    @PostMapping("/deleteStudentInfo")
    @ResponseBody
    public CommonResult deleteStudentInfo(@RequestBody SmsStudent smsStudent) {
        boolean isDeleted = studentService.deleteStudentInfo(smsStudent);
        if (!isDeleted) {
            return CommonResult.failed("该学生已经不存在了！");
        }
        return CommonResult.success("删除成功！");
    }
}
