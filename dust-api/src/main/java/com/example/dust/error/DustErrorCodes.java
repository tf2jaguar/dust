package com.example.dust.error;


import io.github.tf2jaguar.micro.core.error.ExceptionEnums;

/**
 * @author ：zhanguodong
 * @since ：Created in 2021/6/25 18:14
 */
public enum DustErrorCodes implements ExceptionEnums {
    // 异常
    INTERNAL_EXCEPT(10000, "系统内部异常"),
    INVALID_SIGN(10001, "请求加密协议错误"),
    INVALID_IP(10002, "请求IP地址异常");

    private int code;
    private String message;

    DustErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
