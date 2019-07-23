package com.wenhao.mykt.mykttwo.handler.impl;

import com.wenhao.mykt.mykttwo.handler.GateWayHandler;
import org.springframework.stereotype.Component;

@Component
public class ConversationHandler extends GateWayHandler {
    @Override
    public void service() {
        System.out.println("第二关 会话拦截");
        nextService();
    }
}
