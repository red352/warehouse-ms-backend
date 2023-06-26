package com.lyx.warehouse.mapper;

import com.lyx.warehouse.model.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyx.warehouse.model.vo.ProductInfo;

/**
* @author lyx
* @description 针对表【product】的数据库操作Mapper
* @createDate 2023-06-26 09:12:48
* @Entity com.lyx.warehouse.model.entity.Product
*/
public interface ProductMapper extends BaseMapper<Product> {

    ProductInfo productInfoQuery(Long id);
}




