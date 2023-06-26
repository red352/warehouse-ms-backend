package com.lyx.warehouse.model.dto.productAccount;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author lyx
 * @createTime 2023/6/26 10:30
 */
@Getter
@Setter
@ToString
public class ProductAccountAdd {

    /**
     * 门店id
     */
    @NotNull
    private Long storeId;

    /**
     * 商品id
     */
    @NotNull
    private Long productId;

    /**
     * 操作数量
     */
    @NotNull
    private Integer operationNum;
}
