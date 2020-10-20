package com.ttt.chacha.chacha.controller.vo;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * 学生查看排课信息
 * @author:edgarding
 * @date:2020/10/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseDetailVO {
    private String courseName;
    private String teacherName;
    private Integer termNum;
    private String className;
    private Integer classRoomName;
    private String courserTime; //周数
    private Byte state; // 上课状态
}
