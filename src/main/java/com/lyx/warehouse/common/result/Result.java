package com.lyx.warehouse.common.result;

import lombok.*;

import static com.lyx.warehouse.common.result.Results.FAIL;
import static com.lyx.warehouse.common.result.Results.SUCCESS;

/**
 * @author lyx
 * @createTime 2023/6/26 8:53
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS.getCode(), SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success() {
        return Result.success(null);
    }

    public static Result<?> fail() {
        return new Result<>(FAIL.getCode(), FAIL.getMsg(), null);
    }

    public static Result<?> bool(boolean isTrue) {
        return isTrue ? success() : fail();
    }

    public static Result<?> fail(Results results) {
        return new Result<>(results.getCode(), results.getMsg(), null);
    }
}
