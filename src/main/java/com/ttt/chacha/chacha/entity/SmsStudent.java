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
public class SmsStudent {
    private Integer id;
    private Integer userId;
    private String name;
    private Integer age;
    private String address;
    private Byte state;
    private String duringSchoolTime;
    private String identityNumber;
}
