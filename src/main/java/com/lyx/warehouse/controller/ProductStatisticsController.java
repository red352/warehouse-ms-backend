package com.lyx.warehouse.controller;

import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.model.vo.ProductInfo;
import com.lyx.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyx
 * @createTime 2023/6/26 12:03
 */
@RestController
@RequestMapping("/statistics")
public class ProductStatisticsController {
    @Autowired
    private ProductService productService;

    @GetMapping("/count")
    public Result<ProductInfo> productInfoQuery(Long id){
        return productService.productInfoQuery(id);
    }
}
