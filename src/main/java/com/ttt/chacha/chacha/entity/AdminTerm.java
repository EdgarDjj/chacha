package com.ttt.chacha.chacha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminTerm {
    private Integer id;
    private Integer termNum;
    private Integer classId;
    private Timestamp termEndTime;
    private Timestamp termStartTime;
}
