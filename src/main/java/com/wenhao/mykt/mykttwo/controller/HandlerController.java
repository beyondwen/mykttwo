package com.wenhao.mykt.mykttwo.controller;

import com.wenhao.mykt.mykttwo.service.GatewayHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerController {

//    @Autowired
//    private FactoryHandler factoryHandler;

    @Autowired
    private GatewayHandlerService gatewayHandlerService;


    @GetMapping("/")
    public String handler() {
        gatewayHandlerService.getDBHandler().service();
        return "成功";
    }
}
