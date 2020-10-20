package com.ttt.chacha.chacha.service.impl;

import com.ttt.chacha.chacha.dao.StudentMapper;
import com.ttt.chacha.chacha.entity.SmsStudent;
import com.ttt.chacha.chacha.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public SmsStudent insertStudentInfo(SmsStudent smsStudent) {
        SmsStudent student = selectStudentByName(smsStudent.getName());
        if (smsStudent == null) {
            return null;
        }
    }

    private SmsStudent selectStudentByName(String name) {
        return studentMapper.selectStudentByName(name);
    }


}
