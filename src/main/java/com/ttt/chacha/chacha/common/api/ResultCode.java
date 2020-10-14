package com.ttt.chacha.chacha.common.api;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2020/10/14
 **/
public enum ResultCode implements IErrorCode{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    PARAM_ERROR(400,"请求参数不正确"),
    VALIDATE_FAILED(404, "请求路径不正确"),
    FORBIDDEN(403, "没有相关权限");
    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
