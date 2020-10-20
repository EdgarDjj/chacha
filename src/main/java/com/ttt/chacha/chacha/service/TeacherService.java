package com.ttt.chacha.chacha.service;

import com.ttt.chacha.chacha.entity.TmsTeacher;

import java.util.List;

public interface TeacherService
{

    List<TmsTeacher> getTeacherList(Integer pageNum, Integer pageSize);

    int updateTeacher(TmsTeacher tmsTeacher);

    int deleteTeacherById(TmsTeacher tmsTeacher);

    int addTeacher(TmsTeacher tmsTeacher);

    TmsTeacher selectTeacherByUserId(TmsTeacher tmsTeacher);
}
