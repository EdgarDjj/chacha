---
title: 教务系统
date: 2020-10-13 16:21:28
tags: 项目
categories:
- 项目
---

# 教务系统

## 数据库结构

### 数据库建表规则

* 每个表必须带个 id —— int
  * 自增  
  * primary key
  * not null
* id字段往前排
* 含有别的表的主键时 带上 TABLE_NAME_id
* 时间字段 update_time/start_time/end_time
  * datetime
* 判断字段必须以 **is_ ** 为前缀
  * tinyint
* 枚举类型
  * tinyint
  * default
  * 备注各数字含义
* 学生模块前缀 sms_
* 教师模块前缀 tms_
* 后台模块前缀 admin_
* 类地址address，备注remark
  * varchar(255) 
* 个人信息
  * varchar（100）
* number字段
  * int
* state字段 （请假状态）tinyint
  * 0=其他，1=正常，2=病假，3=时间，4=产假
  * 1=学生，2=老师，3=管理员 admin_user
  * 0 统一为其他
* sex字段（性别）tinyint
  * 0=男，1=女

### 学生模块



### 教师模块



### 后台管理模块

