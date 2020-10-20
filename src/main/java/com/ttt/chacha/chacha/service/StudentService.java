package com.ttt.chacha.chacha.service;

import com.ttt.chacha.chacha.entity.SmsStudent;

import java.util.List;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
public interface StudentService {
    boolean insertStudentInfo(SmsStudent smsStudent);

    SmsStudent selectStudentById(Integer id);

    List<SmsStudent> getStudentInfoList(Integer pageNum, Integer pageSize);

    boolean updateStudentInfo(SmsStudent smsStudent);
}
