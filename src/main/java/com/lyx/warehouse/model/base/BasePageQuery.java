package com.lyx.warehouse.model.base;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author lyx
 * @createTime 2023/6/26 9:19
 */
@Getter
@Setter
public class BasePageQuery {

    @NonNull
    private Long current;

    @NonNull
    private Long size;
}
