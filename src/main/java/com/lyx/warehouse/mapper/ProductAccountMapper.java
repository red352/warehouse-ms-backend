package com.lyx.warehouse.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyx.warehouse.model.entity.ProductAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyx.warehouse.model.vo.ProductAccountVo;

import java.time.LocalDateTime;

/**
* @author lyx
* @description 针对表【product_account】的数据库操作Mapper
* @createDate 2023-06-26 10:25:54
* @Entity com.lyx.warehouse.model.entity.ProductAccount
*/
public interface ProductAccountMapper extends BaseMapper<ProductAccount> {

    Page<ProductAccountVo> productAccountQuery(Page objectPage, Long productId, LocalDateTime createTime);
}




