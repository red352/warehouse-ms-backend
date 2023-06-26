package com.lyx.warehouse.model.dto.message;

import com.lyx.warehouse.model.base.BasePageQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author lyx
 * @createTime 2023/6/26 13:40
 */
@Getter
@Setter
@ToString
public class MessageQuery extends BasePageQuery {

    private LocalDateTime leOutTime;
    private LocalDateTime gtOutTime;
}
