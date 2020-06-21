package anxiuze.biz.consumer.bizconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author anxiuze
 * @date 2020/4/19 11:35
 * @Description:
 */
@Service
public class BlogService {

    @RabbitListener(queues = "blogJavaQueue")
    public void blogJavaReceiver(String blog) {
        System.out.println("java端接收到消息：" + blog);
    }

    @RabbitListener(queues = "blogPythonQueue")
    public void blogPythonReceiver(String blog) {
        System.out.println("python端接收到消息：" + blog);
    }

    @RabbitListener(queues = "blogAllQueue")
    public void blogAllReceiver(String blog) {
        System.out.println("总接收端接收到消息：" + blog);
    }

}
