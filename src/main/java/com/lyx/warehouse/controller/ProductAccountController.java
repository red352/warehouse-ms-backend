package com.lyx.warehouse.controller;

import com.lyx.warehouse.common.aop.ProductOut;
import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.model.dto.productAccount.ProductAccountAdd;
import com.lyx.warehouse.model.dto.productAccount.ProductAccountQuery;
import com.lyx.warehouse.model.vo.ProductAccountVo;
import com.lyx.warehouse.service.ProductAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lyx
 * @createTime 2023/6/26 10:27
 */
@RestController
@RequestMapping("/productAccount")
@Validated
public class ProductAccountController {
    @Autowired
    private ProductAccountService productAccountService;

    /**
     * 出库
     * @param productAccountAdd
     * @return
     */
    @PostMapping("/out")
    @ProductOut
    public Result<?> productOut(@RequestBody @Valid ProductAccountAdd productAccountAdd) {
        return productAccountService.productOut(productAccountAdd);
    }

    /**
     * 入库
     * @param productAccountAdd
     * @return
     */
    @PostMapping("/in")
    public Result<?> productIn(@RequestBody @Valid ProductAccountAdd productAccountAdd) {
        return productAccountService.productIn(productAccountAdd);
    }

    /**
     * 分页查询
     * @param productAccountQuery
     * @return
     */
    @PostMapping("/get/page")
    public Result<PageResult<ProductAccountVo>> productAccountQuery(@RequestBody @Valid ProductAccountQuery productAccountQuery) {
        return productAccountService.productAccountQuery(productAccountQuery);
    }


}
