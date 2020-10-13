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
public class SmsAppraise {
    private Integer id;
    private Integer termId;
    private Integer studentId;
    private Integer teacherId;
    private Byte studentAppraiseState;
}
