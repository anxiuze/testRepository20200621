package anxiuze.biz.consumer.bizconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anxiuze
 * @date 2020/4/19 10:52
 * @Description:
 */
@Configuration
public class EmailConfig {

    @Bean
    DirectExchange emailExchange() {
        return new DirectExchange("emailExchange");
    }

    @Bean
    Queue emailQueue() {
        return new Queue("emailQueue");
    }

    @Bean
    Binding emailBind() {
        return BindingBuilder.bind(emailQueue()).to(emailExchange()).with("emailRouting");
    }

}
