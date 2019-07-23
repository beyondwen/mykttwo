package com.wenhao.mykt.mykttwo.controller;

import com.wenhao.mykt.mykttwo.handler.FactoryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerController {

    @Autowired
    private FactoryHandler factoryHandler;


    @GetMapping("/")
    public String handler() {
        factoryHandler.getGateWayHandler().service();
        return "成功";
    }
}
