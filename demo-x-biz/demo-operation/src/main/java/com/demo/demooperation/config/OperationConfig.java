package com.demo.demooperation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/12/17.
 */
@Configuration
@ConfigurationProperties(prefix = "operation.seller.default")
@RefreshScope
@Data
public class OperationConfig {

    /**
     * 默认的配置
     */
    private List<String> idList;

    /**
     * 记录缓存时间
     */
    private Integer time = 300;

}
