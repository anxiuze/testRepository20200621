package anxiuze.biz.productor.bizproductor.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anxiuze
 * @date 2020/4/130:07
 * @Description:
 */
@Configuration
public class EmailConfig {

    @Bean
    DirectExchange emailExchange() {
        return new DirectExchange("emailExchange");
    }

}
