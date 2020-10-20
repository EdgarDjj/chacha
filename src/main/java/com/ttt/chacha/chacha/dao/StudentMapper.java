package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.SmsStudent;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
public interface StudentMapper {

    SmsStudent selectStudentByName(String name);
}
