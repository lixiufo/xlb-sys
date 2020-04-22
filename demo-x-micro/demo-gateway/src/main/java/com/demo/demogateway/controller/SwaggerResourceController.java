package com.demo.demogateway.controller;

import com.demo.demogateway.config.SwaggerConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import javax.annotation.Resource;
import java.util.List;

/**
 * swagger聚合接口，三个接口都是swagger-ui.html需要访问的接口
 *
 * @author PF.W
 * @since <pre>2019/04/09</pre>
 */
@RestController
@RequestMapping("/swagger-resources")
@Profile({"test"})
public class SwaggerResourceController {

    @Resource
    private SwaggerConfig swaggerConfig;

    @RequestMapping(value = "/configuration/security")
    public ResponseEntity<SecurityConfiguration> securityConfiguration() {
        return new ResponseEntity<>(SecurityConfigurationBuilder.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/configuration/ui")
    public ResponseEntity<UiConfiguration> uiConfiguration() {
        return new ResponseEntity<>(UiConfigurationBuilder.builder().build(), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return new ResponseEntity<>(swaggerConfig.get(), HttpStatus.OK);
    }
}
