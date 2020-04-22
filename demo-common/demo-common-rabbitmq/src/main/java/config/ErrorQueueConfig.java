package config;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/8.
 */
@Data
@Configuration
public class ErrorQueueConfig {

    /**
     * 默认的交换机key
     */
    public static final String X_DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";

    /**
     * 默认的路由key
     */
    public static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    /**
     * 默认异常消息处理器
     */
    public static final String DEFAULT_ERROR_EXCHANGE = "error.exchange";

    /**
     * 默认异常处理的路由
     */
    public static final String DEFAULT_ERROR_ROUTING_KEY = "error";

    /**
     * 默认的异常队列
     */
    public static final String DEFAULT_ERROR_MESSAGE = "error.message";

    /**
     * 异常消息队列
     *
     * @return nn
     */
    @Bean
    public Queue errorMessage() {
        return QueueBuilder
                .durable(DEFAULT_ERROR_MESSAGE)
                .build();
    }

    /**
     * 异常消息交换机
     *
     * @return nn
     */
    @Bean
    DirectExchange errorExchange() {
        return new DirectExchange(DEFAULT_ERROR_EXCHANGE);
    }

    /**
     * 异常消息队列+交换机绑定
     *
     * @param errorMessage  nn
     * @param errorExchange nn
     * @return nn
     */
    @Bean
    Binding dlxBinding(Queue errorMessage, DirectExchange errorExchange) {
        return BindingBuilder.bind(errorMessage)
                .to(errorExchange)
                .with(DEFAULT_ERROR_ROUTING_KEY);
    }
}
