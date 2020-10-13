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
public class TmsAppraise {
    private Integer id;
    private Integer teacherId;
    private Integer termId;
    private Integer score;
}
