package com.lyx.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.mapper.ProductAccountMapper;
import com.lyx.warehouse.model.dto.productAccount.ProductAccountAdd;
import com.lyx.warehouse.model.dto.productAccount.ProductAccountQuery;
import com.lyx.warehouse.model.entity.ProductAccount;
import com.lyx.warehouse.model.entity.StoreProduct;
import com.lyx.warehouse.model.vo.ProductAccountVo;
import com.lyx.warehouse.service.ProductAccountService;
import com.lyx.warehouse.service.ProductService;
import com.lyx.warehouse.service.StoreProductService;
import lombok.AllArgsConstructor;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lyx
 * @description 针对表【product_account】的数据库操作Service实现
 * @createDate 2023-06-26 10:25:54
 */
@Service
@AllArgsConstructor
public class ProductAccountServiceImpl extends ServiceImpl<ProductAccountMapper, ProductAccount>
        implements ProductAccountService {

    private StoreProductService storeProductService;

    @Override
    public Result<?> productOut(ProductAccountAdd productAccountAdd) {
        Integer num = ((ProductAccountServiceImpl) AopContext.currentProxy()).doProductOpt(productAccountAdd, ProductAccount.OPT_OUT);
        return Result.success(num);
    }

    @Override
    public Result<?> productIn(ProductAccountAdd productAccountAdd) {
        Integer num = ((ProductAccountServiceImpl) AopContext.currentProxy()).doProductOpt(productAccountAdd, ProductAccount.OPT_IN);
        return Result.success(num);
    }

    @Override
    public Result<PageResult<ProductAccountVo>> productAccountQuery(ProductAccountQuery productAccountQuery) {
        Page<ProductAccountVo> accountPage = baseMapper.productAccountQuery(new Page<>(productAccountQuery.getCurrent(), productAccountQuery.getSize()), productAccountQuery.getProductId(), productAccountQuery.getCreateTime());
        long current = accountPage.getCurrent();
        long size = accountPage.getSize();
        long total = accountPage.getTotal();
        PageResult<ProductAccountVo> pageResult = new PageResult<>(current, size, total, accountPage.getRecords());
        return Result.success(pageResult);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer doProductOpt(ProductAccountAdd productAccountAdd, Integer optType) {
        ProductAccount productAccount = copyToProductAccount(productAccountAdd, optType);
        // TODO: 2023/6/26 保存台账流水
        save(productAccount);
        // TODO: 2023/6/26 修改库存
        Integer oldProductNum = storeProductService.lambdaQuery()
                .select(StoreProduct::getProductNum)
                .eq(StoreProduct::getProductId, productAccount.getProductId())
                .eq(StoreProduct::getStoreId, productAccount.getStoreId())
                .one().getProductNum();
        Integer finalNum = getnewProductNum(productAccount, optType, oldProductNum);
        storeProductService.lambdaUpdate()
                .set(StoreProduct::getProductNum, finalNum)
                .eq(StoreProduct::getProductId, productAccount.getProductId())
                .eq(StoreProduct::getStoreId, productAccount.getStoreId())
                .eq(StoreProduct::getProductNum, oldProductNum)
                .update();
        return finalNum;

    }

    private Integer getnewProductNum(ProductAccount productAccount, Integer optType, Integer oldProductNum) {
        Integer operationNum = productAccount.getOperationNum();
        int finalNum;
        if (ProductAccount.OPT_IN.equals(optType)) {
            finalNum = oldProductNum + operationNum;
        } else if (ProductAccount.OPT_OUT.equals(optType)) {
            finalNum = oldProductNum - operationNum;
        } else {
            finalNum = -1;
        }
        return switchFinalNum(finalNum);
    }

    private Integer switchFinalNum(int finalNum) {
        if (finalNum >= 0) {
            return finalNum;
        }
        throw new RuntimeException();
    }


    public static <T> ProductAccount copyToProductAccount(T data, Integer optType) {
        ProductAccount productAccount = new ProductAccount();
        BeanUtils.copyProperties(data, productAccount);
        productAccount.setOperationType(optType);
        return productAccount;
    }
}




