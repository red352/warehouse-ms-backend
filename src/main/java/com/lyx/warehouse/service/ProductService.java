package com.lyx.warehouse.service;

import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.model.dto.product.ProductQuery;
import com.lyx.warehouse.model.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyx.warehouse.model.vo.ProductInfo;
import com.lyx.warehouse.model.vo.ProductVo;

/**
* @author lyx
* @description 针对表【product】的数据库操作Service
* @createDate 2023-06-26 09:12:48
*/
public interface ProductService extends IService<Product> {

    Result<PageResult<ProductVo>> productQueryByPage(ProductQuery productQuery);

    Result<ProductInfo> productInfoQuery(Long id);
}
