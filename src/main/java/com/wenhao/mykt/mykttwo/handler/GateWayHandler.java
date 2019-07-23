package com.wenhao.mykt.mykttwo.handler;

public abstract class GateWayHandler {

    private GateWayHandler nextGateWayHandler;

    public abstract void service();

    protected void nextService() {
        if (nextGateWayHandler != null) {
            nextGateWayHandler.service();
        }
    }

    protected GateWayHandler setNextHandler(GateWayHandler gateWayHandler) {
        this.nextGateWayHandler = gateWayHandler;
        return nextGateWayHandler;
    }
}
