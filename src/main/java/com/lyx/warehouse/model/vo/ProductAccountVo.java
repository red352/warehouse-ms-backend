package com.lyx.warehouse.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author lyx
 * @createTime 2023/6/26 11:23
 */
@Getter
@Setter
@ToString
public class ProductAccountVo {

    private Long id;

    private Long storeId;

    private Long productId;

    private Integer operationType;

    private Integer operationNum;

    private LocalDateTime createTime;
}
