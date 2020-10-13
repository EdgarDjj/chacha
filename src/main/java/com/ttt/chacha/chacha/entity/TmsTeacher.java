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
public class TmsTeacher {
    private Integer id;
    private String name;
    private Integer age;
    private Byte sex;
    private Byte level;
    private String phone;
    private String address;
    private Byte state;
}
