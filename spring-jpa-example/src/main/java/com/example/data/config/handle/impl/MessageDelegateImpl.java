package com.example.data.config.handle.impl;

import com.example.data.config.handle.MessageDelegate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageDelegateImpl implements MessageDelegate {

    @Override
    public void handleMessage(String message) {
        log.info("收到消息：{}", message);
    }
}
