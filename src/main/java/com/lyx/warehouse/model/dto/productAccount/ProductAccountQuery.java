package com.lyx.warehouse.model.dto.productAccount;

import com.lyx.warehouse.model.base.BasePageQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author lyx
 * @createTime 2023/6/26 11:21
 */
@Getter
@Setter
@ToString
public class ProductAccountQuery extends BasePageQuery {

    @NotNull
    private Long productId;

    @NotNull
    private LocalDateTime createTime;
}
