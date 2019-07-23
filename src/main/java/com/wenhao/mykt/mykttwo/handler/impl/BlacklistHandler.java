package com.wenhao.mykt.mykttwo.handler.impl;

import com.wenhao.mykt.mykttwo.handler.GateWayHandler;
import org.springframework.stereotype.Component;

@Component
public class BlacklistHandler extends GateWayHandler {
    @Override
    public void service() {
        System.out.println("第三关 黑名单拦截");
        nextService();
    }
}
