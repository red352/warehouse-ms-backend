package com.lyx.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.warehouse.model.entity.Store;
import com.lyx.warehouse.service.StoreService;
import com.lyx.warehouse.mapper.StoreMapper;
import org.springframework.stereotype.Service;

/**
* @author lyx
* @description 针对表【store】的数据库操作Service实现
* @createDate 2023-06-26 10:26:04
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

}




