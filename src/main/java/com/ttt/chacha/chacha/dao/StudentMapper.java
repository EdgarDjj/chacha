package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.SmsStudent;

import java.util.List;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
public interface StudentMapper {
    SmsStudent selectStudentByIdentityNumber(String identityNumber);

    void insertStudentInfo(SmsStudent smsStudent);

    SmsStudent selectStudentByUserId(Integer userId);

    List<SmsStudent> getStudentInfoList();

    boolean updateStudentInfo(SmsStudent smsStudent);

    void deleteStudentInfo(Integer userId);
}
