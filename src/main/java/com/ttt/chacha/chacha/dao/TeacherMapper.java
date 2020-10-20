package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.TmsTeacher;

import java.util.List;

public interface TeacherMapper
{

    List<TmsTeacher> getTeacherList();

    int updateTeacher(TmsTeacher tmsTeacher);

    int deleteTeacherById(TmsTeacher tmsTeacher);

    int addTeacher(TmsTeacher tmsTeacher);

    TmsTeacher selectTeacherByUserId(TmsTeacher tmsTeacher);
}
