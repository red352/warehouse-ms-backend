package com.lyx.warehouse.controller;

import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.model.dto.product.ProductAdd;
import com.lyx.warehouse.model.dto.product.ProductQuery;
import com.lyx.warehouse.model.dto.product.ProductUpdate;
import com.lyx.warehouse.model.entity.Product;
import com.lyx.warehouse.model.vo.ProductVo;
import com.lyx.warehouse.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lyx
 * @createTime 2023/6/26 9:22
 */
@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Result<?> productAdd(@RequestBody @Valid ProductAdd productAdd) {
        Product product = copyToProduct(productAdd);
        productService.save(product);
        return Result.success(product.getId());
    }


    @PutMapping("/update")
    public Result<?> productUpdate(@RequestBody ProductUpdate productUpdate) {
        Product product = copyToProduct(productUpdate);
        productService.updateById(product);
        return Result.success();
    }

    @DeleteMapping("delete")
    public Result<?> productDelete(Long id) {
        boolean b = productService.removeById(id);
        return Result.bool(b);
    }

    @PostMapping("/get/page")
    public Result<PageResult<ProductVo>> productQueryByPage(@RequestBody @Valid ProductQuery productQuery) {
        return productService.productQueryByPage(productQuery);
    }


    public static <T> Product copyToProduct(T data) {
        Product product = new Product();
        BeanUtils.copyProperties(data, product);
        return product;
    }


}
