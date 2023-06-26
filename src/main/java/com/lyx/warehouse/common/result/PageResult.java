package com.lyx.warehouse.common.result;

import lombok.*;

import java.util.List;

/**
 * @author lyx
 * @createTime 2023/6/26 8:54
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageResult <T> {

    private Long current;
    private Long size;
    private Long total;
    private List<T> data;
}
