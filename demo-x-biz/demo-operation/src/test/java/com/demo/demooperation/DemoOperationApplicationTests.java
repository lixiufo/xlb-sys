package com.demo.demooperation;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoOperationApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(new BCryptPasswordEncoder().encode("xlb@2019"));
    }

}
