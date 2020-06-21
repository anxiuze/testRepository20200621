package anxiuze.biz.consumer.bizconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anxiuze
 * @date 2020/4/20 10:04
 * @Description:
 */
@Configuration
public class HeadersConfig {

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange("headersExchange");
    }

    @Bean
    Queue headersQueue1() {
        return new Queue("headersQueue1", true);
    }

    @Bean
    Queue headersQueue2() {
        return new Queue("headersQueue2", true);
    }

    @Bean
    Queue headersQueue3() {
        return new Queue("headersQueue3", true);
    }

    @Bean
    Queue headersQueue4() {
        return new Queue("headersQueue4", true);
    }

    @Bean
    Binding headerBind1() {
        return BindingBuilder.bind(headersQueue1()).to(headersExchange()).whereAll("token", "id").exist();
    }

    @Bean
    Binding headerBind2() {
        return BindingBuilder.bind(headersQueue2()).to(headersExchange()).whereAny("token", "id").exist();
    }

    @Bean
    Binding headerBind3() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "123");
        map.put("id", "123");
        return BindingBuilder.bind(headersQueue3()).to(headersExchange()).whereAll(map).match();
    }

    @Bean
    Binding headerBind4() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "123");
        map.put("id", "123");
        return BindingBuilder.bind(headersQueue4()).to(headersExchange()).whereAny(map).match();
    }


}
