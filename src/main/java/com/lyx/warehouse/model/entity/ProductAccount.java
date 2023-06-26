package com.lyx.warehouse.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lyx
 * @TableName product_account
 */
@TableName(value = "product_account")
@Data
public class ProductAccount implements Serializable {
    public static final Integer OPT_OUT = 0;
    public static final Integer OPT_IN = 1;

    /**
     * 台账id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 门店id
     */
    @TableField(value = "store_id")
    private Long storeId;

    /**
     * 商品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 操作类型(0:”出账“,1:”入账“）
     */
    @TableField(value = "operation_type")
    private Integer operationType;

    /**
     * 操作数量
     */
    @TableField(value = "operation_num")
    private Integer operationNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}