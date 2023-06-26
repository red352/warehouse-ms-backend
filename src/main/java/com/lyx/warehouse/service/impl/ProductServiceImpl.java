package com.lyx.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.mapper.ProductMapper;
import com.lyx.warehouse.model.dto.product.ProductQuery;
import com.lyx.warehouse.model.entity.Product;
import com.lyx.warehouse.model.vo.ProductInfo;
import com.lyx.warehouse.model.vo.ProductVo;
import com.lyx.warehouse.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author lyx
 * @description 针对表【product】的数据库操作Service实现
 * @createDate 2023-06-26 09:12:48
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

    @Override
    public Result<PageResult<ProductVo>> productQueryByPage(ProductQuery productQuery) {
        String name = productQuery.getName();
        Page<Product> productPage = this.lambdaQuery()
                .like(StringUtils.hasText(name), Product::getName, name)
                .orderByDesc(Product::getCreateTime)
                .page(new Page<>(productQuery.getCurrent(), productQuery.getSize()));
        PageResult<ProductVo> voPageResult = copyToVoPageResult(productPage);
        return Result.success(voPageResult);
    }

    @Override
    public Result<ProductInfo> productInfoQuery(Long id) {
        ProductInfo productInfo = baseMapper.productInfoQuery(id);
        return null;
    }

    private PageResult<ProductVo> copyToVoPageResult(Page<Product> productPage) {
        List<Product> productList = productPage.getRecords();
        List<ProductVo> productVoList = productList.stream().map(this::productToVo).toList();
        long current = productPage.getCurrent();
        long size = productPage.getSize();
        long total = productPage.getTotal();
        return new PageResult<>(current, size, total, productVoList);

    }

    private ProductVo productToVo(Product product) {
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(product, productVo);
        return productVo;
    }
}




