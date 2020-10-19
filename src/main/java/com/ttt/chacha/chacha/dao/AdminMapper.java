package com.ttt.chacha.chacha.dao;

import com.ttt.chacha.chacha.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/19
 **/
@Repository
public interface AdminMapper {

    AdminUser selectUserByNameAndTelephone(@Param("name") String name, @Param("telephone") String telephone);

    AdminUser selectAdminUserByName(String name);

    List<AdminUser> getList();

    AdminUser userRegister(AdminUser adminUserParam);

    void userProfile(AdminUser adminUserParam);
}
