package com.lyx.warehouse.model.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lyx
 * @createTime 2023/6/26 9:15
 */
@Getter
@Setter
@ToString
public class ProductUpdate {

    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品规格
     */
    private String spec;

    /**
     * 规格类型(0:ml,1:个数)
     */
    private Integer specType;

    /**
     * 价格(*100)
     */
    private Integer price;

}
