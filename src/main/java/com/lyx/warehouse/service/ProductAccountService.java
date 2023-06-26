package com.lyx.warehouse.service;

import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.model.dto.productAccount.ProductAccountAdd;
import com.lyx.warehouse.model.dto.productAccount.ProductAccountQuery;
import com.lyx.warehouse.model.entity.ProductAccount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyx.warehouse.model.vo.ProductAccountVo;

/**
* @author lyx
* @description 针对表【product_account】的数据库操作Service
* @createDate 2023-06-26 10:25:54
*/
public interface ProductAccountService extends IService<ProductAccount> {

    Result<?> productOut(ProductAccountAdd productAccountAdd);

    Result<?> productIn(ProductAccountAdd productAccountAdd);

    Result<PageResult<ProductAccountVo>> productAccountQuery(ProductAccountQuery productAccountQuery);
}
