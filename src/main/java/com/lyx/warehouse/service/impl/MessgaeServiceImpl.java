package com.lyx.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.mapper.MessgaeMapper;
import com.lyx.warehouse.model.dto.message.MessageQuery;
import com.lyx.warehouse.model.entity.Messgae;
import com.lyx.warehouse.model.redis.RedisKey;
import com.lyx.warehouse.service.MessgaeService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author lyx
 * @description 针对表【messgae】的数据库操作Service实现
 * @createDate 2023-06-26 12:46:05
 */
@Service
@AllArgsConstructor
public class MessgaeServiceImpl extends ServiceImpl<MessgaeMapper, Messgae>
        implements MessgaeService {

    private RedisTemplate<String, Long> redisTemplate;


    @Override
    public void sendPhoneText(Set<ZSetOperations.TypedTuple<Long>> ids) {
        // TODO: 2023/6/26 超时未读取的数据，发送短信提醒
    }

    @Override
    public Result<?> doReadMessage(Long id) {
        Messgae messgae = new Messgae();
        messgae.setId(id);
        messgae.setStatus(Messgae.READ);
        updateById(messgae);
        redisTemplate.opsForZSet().remove(RedisKey.MESSAGE_SEND_KEY, id);
        return Result.success();
    }

    @Override
    public Result<PageResult<Messgae>> messagePageQuery(MessageQuery messageQuery) {
        Page<Messgae> page = this.lambdaQuery()
                .le(Messgae::getOptOutTime, messageQuery.getLeOutTime())
                .gt(Messgae::getOptOutTime, messageQuery.getGtOutTime())
                .page(new Page<>(messageQuery.getCurrent(), messageQuery.getSize()));
        PageResult<Messgae> pageResult = copyToPageResult(page);
        return Result.success(pageResult);
    }

    private PageResult<Messgae> copyToPageResult(Page<Messgae> page) {
        List<Messgae> records = page.getRecords();
        long total = page.getTotal();
        long size = page.getSize();
        long current = page.getCurrent();
        return new PageResult<>(current, size, total, records);

    }
}




