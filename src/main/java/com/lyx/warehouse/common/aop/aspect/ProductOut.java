package com.lyx.warehouse.common.aop.aspect;

import com.lyx.warehouse.model.dto.productAccount.ProductAccountAdd;
import com.lyx.warehouse.model.entity.Messgae;
import com.lyx.warehouse.service.MessgaeService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static com.lyx.warehouse.model.redis.RedisKey.MESSAGE_SEND_KEY;

/**
 * @author lyx
 * @createTime 2023/6/26 12:49
 */
@Aspect
@Component
public class ProductOut {
    @Autowired
    private MessgaeService messgaeService;
    @Resource
    private RedisTemplate<String, Long> redisTemplate;

    @Around("@annotation(com.lyx.warehouse.common.aop.ProductOut)")
    public Object logParam(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceeded = joinPoint.proceed();
        // 获取方法的参数
        Object[] args = joinPoint.getArgs();

        // 处理方法的参数
        for (Object arg : args) {
            if (arg instanceof ProductAccountAdd productAccountAdd) {
                Messgae message = new Messgae();
                message.setStatus(Messgae.UN_READ);
                message.setUserId(Messgae.ADMIN_ID);
                message.setMessage("商品出库成功，id是：" + productAccountAdd.getProductId());
                message.setOptOutTime(LocalDateTime.now());
                messgaeService.save(message);
                Long messageId = message.getId();
                // TODO: 2023/6/26 设置score为3个小时
                long epochSecond = LocalDateTime.now().plusHours(3L).toEpochSecond(ZoneOffset.ofHours(8));
                redisTemplate.opsForZSet().add(MESSAGE_SEND_KEY, messageId, epochSecond);
            }
        }

        return proceeded;
    }
}
