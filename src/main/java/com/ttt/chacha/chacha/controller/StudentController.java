package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.controller.api.StudentControllerApi;
import com.ttt.chacha.chacha.entity.AdminUser;
import com.ttt.chacha.chacha.entity.SmsStudent;
import com.ttt.chacha.chacha.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
@Controller
@RequestMapping("/student")
public class StudentController implements StudentControllerApi {

    @Resource
    StudentService studentService;

    @Override
    public CommonResult<SmsStudent> getStudentInfo(AdminUser user) {

    }

    @Override
    @RequestMapping("/insertStudentInfo")
    @ResponseBody
    public CommonResult<SmsStudent> insertStudentInfo(@RequestBody SmsStudent smsStudent) {
        SmsStudent student = studentService.insertStudentInfo(smsStudent);
        if(student == null) {
            return CommonResult.failed("插入学生信息失败，已存在！");
        }
        return CommonResult.success(student);
    }
}
