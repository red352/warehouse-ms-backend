package com.lyx.warehouse.controller;

import com.lyx.warehouse.common.result.PageResult;
import com.lyx.warehouse.common.result.Result;
import com.lyx.warehouse.model.dto.message.MessageQuery;
import com.lyx.warehouse.model.entity.Messgae;
import com.lyx.warehouse.service.MessgaeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lyx
 * @createTime 2023/6/26 13:34
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessgaeService messgaeService;

    /**
     * 设置消息已读
     * @param id
     * @return
     */
    @GetMapping
    public Result<?> doReadMessage(Long id){
        return messgaeService.doReadMessage(id);
    }

    @PostMapping("/get/page")
    public Result<PageResult<Messgae>> messagePageQuery(@RequestBody MessageQuery messageQuery){
        return messgaeService.messagePageQuery(messageQuery);
    }
}
