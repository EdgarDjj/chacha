package com.ttt.chacha.chacha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * 用户表
 * @author:edgarding
 * @date:2020/10/13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUser {
    private Integer id;
    private String name;
    private String password;
    private byte state;
    private byte type;
}
