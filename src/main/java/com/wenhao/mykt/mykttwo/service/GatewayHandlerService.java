package com.wenhao.mykt.mykttwo.service;

import com.wenhao.mykt.mykttwo.handler.GateWayHandler;
import com.wenhao.mykt.mykttwo.mapper.GatewayHandlerEntity;
import com.wenhao.mykt.mykttwo.mapper.GatewayHandlerMapper;
import com.wenhao.mykt.mykttwo.util.SpringUtils;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GatewayHandlerService {


    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;

    private GateWayHandler firstGateWayHandler;

    public GatewayHandlerEntity getByHandler(String handlerId) {
        return gatewayHandlerMapper.getByHandler(handlerId);
    }

    public GateWayHandler getDBHandler() {
        if (firstGateWayHandler != null) {
            return firstGateWayHandler;
        }
        //获取第一个handler
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        if (firstGatewayHandlerEntity == null) {
            return null;
        }
        //获取handlerId
        String handlerId1 = firstGatewayHandlerEntity.getHandlerId();
        //通过spring 容器 生成bean
        GateWayHandler firstGatewayHandler = SpringUtils.getBean(handlerId1, GateWayHandler.class);
        //将获取的handler 临时缓存
        GateWayHandler tempHandler = firstGatewayHandler;
        String nextHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        while (!StringUtils.isEmpty(nextHandlerId)) {
            //获取下一个handler
            GatewayHandlerEntity entity = getByHandler(nextHandlerId);
            if (entity == null) {
                break;
            }
            //得到下一个handler的id
            String handlerId2 = entity.getHandlerId();
            //得到下一个handler 对象
            GateWayHandler nextHandler = SpringUtils.getBean(handlerId2, GateWayHandler.class);
            tempHandler.setHandler(nextHandler);
            tempHandler = nextHandler;
            nextHandlerId = entity.getNextHandlerId();
        }
        this.firstGateWayHandler = firstGatewayHandler;
        return firstGatewayHandler;
    }

}