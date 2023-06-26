package com.lyx.warehouse.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName store_product
 */
@TableName(value ="store_product")
@Data
public class StoreProduct implements Serializable {
    /**
     * 门店id
     */
    private Long storeId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 库存总量
     */
    @TableField(value = "product_num")
    private Integer productNum;

    /**
     * 上架时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 商品上架状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}