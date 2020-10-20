package com.ttt.chacha.chacha.service.impl;

import com.github.pagehelper.PageHelper;
import com.ttt.chacha.chacha.dao.StudentMapper;
import com.ttt.chacha.chacha.entity.SmsStudent;
import com.ttt.chacha.chacha.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * StudentService  的实现类
 * @author:edgarding
 * @date:2020/10/20
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public boolean insertStudentInfo(SmsStudent smsStudent) {
        SmsStudent student = selectStudentByIdentityNumber(smsStudent.getIdentityNumber());
        // 如果已经存在信息
        if (student != null) {
            return false;
        }
        studentMapper.insertStudentInfo(smsStudent);
        return true;
    }

    @Override
    public SmsStudent selectStudentByUserId(Integer userId) {
        return studentMapper.selectStudentByUserId(userId);
    }

    @Override
    public List<SmsStudent> getStudentInfoList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return studentMapper.getStudentInfoList();
    }

    @Override
    public boolean updateStudentInfo(SmsStudent smsStudent) {
        return studentMapper.updateStudentInfo(smsStudent);
    }

    @Override
    public boolean deleteStudentInfo(SmsStudent smsStudent) {
        if (selectStudentByUserId(smsStudent.getUserId()) == null) {
            return false;
        }
        studentMapper.deleteStudentInfo(smsStudent.getUserId());
        return true;
    }


    private SmsStudent selectStudentByIdentityNumber(String identityNumber) {
        return studentMapper.selectStudentByIdentityNumber(identityNumber);
    }

}
