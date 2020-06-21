package anxiuze.biz.productor.bizproductor.config;

import org.springframework.amqp.core.HeadersExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anxiuze
 * @date 2020/4/20 9:48
 * @Description:
 */
@Configuration
public class HeadersConfig {

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange("headersExchange");
    }

}
