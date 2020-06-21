package anxiuze.biz.consumer.bizconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author anxiuze
 * @date 2020/4/19 10:55
 * @Description:
 */
@Service
public class EmailReceiver {

    @RabbitListener(queues = "emailQueue")
    public void emailReceiver(String mag) {
        System.out.println("成功接收邮件：" + mag);
    }

}
