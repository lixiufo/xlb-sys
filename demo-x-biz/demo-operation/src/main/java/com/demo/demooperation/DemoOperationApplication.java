package com.demo.demooperation;

import com.demo.democommoncore.constant.consts.CommonConst;
import com.demo.democommonquartz.server.DemoCommonQuartzServer;
import com.demo.demooperation.utils.sys.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableFeignClients
public class DemoOperationApplication {

    @Resource
    private DemoCommonQuartzServer demoCommonQuartzServer;

    public static void main(String[] args) {
        SpringUtils.init(SpringApplication.run(DemoOperationApplication.class, args));
    }

}
