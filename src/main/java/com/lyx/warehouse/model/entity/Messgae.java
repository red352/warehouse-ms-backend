package com.lyx.warehouse.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName messgae
 */
@TableName(value = "messgae")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messgae implements Serializable {
    public static final Integer UN_READ = 0;
    public static final Integer READ = 1;
    public static final Long ADMIN_ID = 1L;
    /**
     * 主键id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 出库时间
     */
    @TableField(value = "opt_out_time")
    private LocalDateTime optOutTime;

    /**
     * 消息正文
     */
    @TableField(value = "message")
    private String message;

    /**
     * 阅读状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}