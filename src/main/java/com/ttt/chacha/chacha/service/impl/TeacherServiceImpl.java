package com.ttt.chacha.chacha.service.impl;

import com.github.pagehelper.PageHelper;
import com.ttt.chacha.chacha.dao.TeacherMapper;
import com.ttt.chacha.chacha.entity.TmsTeacher;
import com.ttt.chacha.chacha.service.TeacherService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<TmsTeacher> getTeacherList(Integer pageNum, Integer pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<TmsTeacher> list = teacherMapper.getTeacherList();
        return list;
    }
}
