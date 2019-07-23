package com.wenhao.mykt.mykttwo.handler;

import com.wenhao.mykt.mykttwo.handler.impl.BlacklistHandler;
import com.wenhao.mykt.mykttwo.handler.impl.ConversationHandler;
import com.wenhao.mykt.mykttwo.handler.impl.CurrentLimitHandler;
import org.springframework.stereotype.Component;

@Component
public class FactoryHandler {

    public GateWayHandler getGateWayHandler() {
        //第一个handler
        GateWayHandler currentLimitHandler = new CurrentLimitHandler();
        //第二个handler
        GateWayHandler conversationHandler = new ConversationHandler();
        //设置下级handler
        currentLimitHandler.setNextHandler(conversationHandler);
        //第三个handler
        GateWayHandler blacklistHandler = new BlacklistHandler();
        //设置下级handler
        conversationHandler.setNextHandler(blacklistHandler);
        return currentLimitHandler;
    }
}
