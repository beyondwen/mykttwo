package com.wenhao.mykt.mykttwo.handler.impl;

import com.wenhao.mykt.mykttwo.handler.GateWayHandler;
import org.springframework.stereotype.Component;

@Component
public class CurrentLimitHandler extends GateWayHandler {
    @Override
    public void service() {
        System.out.println("第一关 网关限流");
        nextService();
    }
}
