package com.lyx.warehouse.schedule;

import com.lyx.warehouse.model.redis.RedisKey;
import com.lyx.warehouse.service.MessgaeService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lyx
 * @createTime 2023/6/26 13:18
 */
@Component
@AllArgsConstructor
public class MessageSend {
    private RedisTemplate<String, Long> redisTemplate;
    private MessgaeService messgaeService;

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void handleMessageSend() {
        // TODO: 2023/6/26 获取超时的消息id
        Set<ZSetOperations.TypedTuple<Long>> ids = redisTemplate.opsForZSet()
                .rangeByScoreWithScores(RedisKey.MESSAGE_SEND_KEY, Double.NEGATIVE_INFINITY, (double) System.currentTimeMillis() / 1000);
        // TODO: 2023/6/26 超时未读取的数据，发送短信提醒
        messgaeService.sendPhoneText(ids);

        redisTemplate.opsForZSet().remove(RedisKey.MESSAGE_SEND_KEY, ids);
    }
}
