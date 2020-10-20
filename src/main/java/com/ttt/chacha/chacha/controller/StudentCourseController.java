package com.ttt.chacha.chacha.controller;

import com.ttt.chacha.chacha.common.api.CommonPage;
import com.ttt.chacha.chacha.common.api.CommonResult;
import com.ttt.chacha.chacha.controller.api.StudentControllerApi;
import com.ttt.chacha.chacha.controller.api.StudentCourseControllerApi;
import com.ttt.chacha.chacha.controller.vo.StudentCourseDetailVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 * 学生排课查询
 * @author:edgarding
 * @date:2020/10/20
 **/
@Controller
@RequestMapping("/student")
public class StudentCourseController implements StudentCourseControllerApi {

    @Override
    public CommonResult<CommonPage<StudentCourseDetailVO>> selectStudentCourseDetailByUserId(Integer userId) {
        return null;
    }
}
