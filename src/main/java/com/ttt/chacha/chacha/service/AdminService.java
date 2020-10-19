package com.ttt.chacha.chacha.service;

import com.ttt.chacha.chacha.common.api.CommonResult;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/19
 **/
public interface AdminService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
