package com.ttt.chacha.chacha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminScheduling {
    private Integer id;
    private Integer courseId;
    private Integer teacherId;
    private Byte state;
    private Integer classId;
    private Integer termId;
    private Integer classRoomId;
    private String courserTime;
}
