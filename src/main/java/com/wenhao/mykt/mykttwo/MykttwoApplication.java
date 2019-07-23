package com.wenhao.mykt.mykttwo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wenhao.mykt.mykttwo.mapper")
public class MykttwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MykttwoApplication.class, args);
    }

}
