package com.ttt.chacha.chacha.service;

import com.ttt.chacha.chacha.entity.TmsTeacher;

import java.util.List;

public interface TeacherService
{

    List<TmsTeacher> getTeacherList(Integer pageNum, Integer pageSize);
}
