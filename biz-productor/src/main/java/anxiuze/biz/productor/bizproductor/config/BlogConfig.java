package anxiuze.biz.productor.bizproductor.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anxiuze
 * @date 2020/4/19 11:25
 * @Description:
 */
@Configuration
public class BlogConfig {

    @Bean
    TopicExchange blogExchange() {
        return new TopicExchange("blogExchange");
    }

}
