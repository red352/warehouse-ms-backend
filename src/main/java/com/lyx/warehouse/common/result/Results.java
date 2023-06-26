package com.lyx.warehouse.common.result;

import lombok.Getter;

/**
 * @author lyx
 * @createTime 2023/6/26 9:34
 */
@Getter
public enum Results {
    /**
     *
     */
    SUCCESS(0,"请求成功"),
    FAIL(1,"请求失败"),
    SYSTEM_ERROR(100,"系统错误"),
    VAIL_ERROR(2,"参数校验失败");

    private final Integer code;
    private final String msg;

    Results(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
