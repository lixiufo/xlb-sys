package com.demo.demogateway;

import org.junit.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

public class asd {
    @Test
    public void TestspringVersionAndspringBootVersion (){
        String springVersion = SpringVersion.getVersion();
        String springBootVersion = SpringBootVersion.getVersion();
        System.out.println(springBootVersion);


    }


}
