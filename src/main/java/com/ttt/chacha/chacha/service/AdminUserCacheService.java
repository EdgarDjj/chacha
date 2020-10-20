package com.ttt.chacha.chacha.service;

/**
 * Description:
 * 后台用户缓存操作类
 *
 * @author:edgarding
 * @date:2020/10/20
 **/
public interface AdminUserCacheService {
    /**
     * 删除用户缓存
     *
     * @param adminId
     */
    void delAdmin(int adminId);

    /**
     * 删除后台用户资源列表缓存
     *
     * @param adminId
     */
    void delResourceList(int adminId);

    /**
     * 当资源信息改变时，删除资源项目后台用户缓存
     */
    void delResourceListByResource(int resourceId);
}
