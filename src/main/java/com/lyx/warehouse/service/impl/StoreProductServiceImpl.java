package com.lyx.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.warehouse.model.entity.StoreProduct;
import com.lyx.warehouse.service.StoreProductService;
import com.lyx.warehouse.mapper.StoreProductMapper;
import org.springframework.stereotype.Service;

/**
* @author lyx
* @description 针对表【store_product】的数据库操作Service实现
* @createDate 2023-06-26 10:26:09
*/
@Service
public class StoreProductServiceImpl extends ServiceImpl<StoreProductMapper, StoreProduct>
    implements StoreProductService{

}




