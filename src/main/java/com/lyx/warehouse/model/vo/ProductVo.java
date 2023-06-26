package com.lyx.warehouse.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author lyx
 * @createTime 2023/6/26 9:21
 */
@Getter
@Setter
@ToString
public class ProductVo {

    /**
     * 商品id
     */
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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
