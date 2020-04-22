package com.demo.demooauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOauthApplication.class, args);
    }

}
