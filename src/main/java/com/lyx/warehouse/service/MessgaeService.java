package com.lyx.warehouse.service;

import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.model.dto.message.MessageQuery;
import com.lyx.warehouse.model.entity.Messgae;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
* @author lyx
* @description 针对表【messgae】的数据库操作Service
* @createDate 2023-06-26 12:46:05
*/
public interface MessgaeService extends IService<Messgae> {

    void sendPhoneText(Set<ZSetOperations.TypedTuple<Long>> ids);

    Result<?> doReadMessage(Long id);

    Result<PageResult<Messgae>> messagePageQuery(MessageQuery messageQuery);
}
