package anxiuze.biz.consumer.bizconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anxiuze
 * @date 2020/4/19 11:29
 * @Description:
 */
@Configuration
public class BlogConfig {

    @Bean
    TopicExchange blogExchange() {
        return new TopicExchange("blogExchange");
    }

    @Bean
    Queue blogJavaQueue() {
        return new Queue("blogJavaQueue");
    }

    @Bean
    Queue blogPythonQueue() {
        return new Queue("blogPythonQueue");
    }


    @Bean
    Queue blogAllQueue() {
        return new Queue("blogAllQueue");
    }

    @Bean
    Binding blogJavaBind() {
        return BindingBuilder.bind(blogJavaQueue()).to(blogExchange()).with("blog.java");
    }

    @Bean
    Binding blogPythonBind() {
        return BindingBuilder.bind(blogPythonQueue()).to(blogExchange()).with("blog.python");
    }

    @Bean
    Binding blogAllBind() {
        return BindingBuilder.bind(blogAllQueue()).to(blogExchange()).with("blog.#");
    }
}
