package com.lyx.warehouse.common.exception;

import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.common.result.Results;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lyx
 * @createTime 2023/6/26 9:50
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<?> globalError(Exception e) {
        e.printStackTrace();
        return Result.fail(Results.SYSTEM_ERROR);
    }
}
