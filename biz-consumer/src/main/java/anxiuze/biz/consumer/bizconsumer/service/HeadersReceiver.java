package anxiuze.biz.consumer.bizconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author anxiuze
 * @date 2020/4/20 11:26
 * @Description:
 */
@Service
public class HeadersReceiver {

    @RabbitListener(queues = "headersQueue1")
    public void headersReceiver1(String msg) {
        System.out.println("headersReceiver 1->接收消息：" + msg);
    }

    @RabbitListener(queues = "headersQueue2")
    public void headersReceiver2(String msg) {
        System.out.println("headersReceiver 2->接收消息：" + msg);
    }

    @RabbitListener(queues = "headersQueue3")
    public void headersReceiver3(String msg) {
        System.out.println("headersReceiver 3->接收消息：" + msg);
    }

    @RabbitListener(queues = "headersQueue4")
    public void headersReceiver4(String msg) {
        System.out.println("headersReceiver 4->接收消息：" + msg);
    }

}
