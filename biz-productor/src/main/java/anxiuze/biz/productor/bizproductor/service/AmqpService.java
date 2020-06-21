package anxiuze.biz.productor.bizproductor.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author anxiuze
 * @date 2020/4/19 10:46
 * @Description:
 */
@Service
public class AmqpService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public void sendEmail(Map<String, String> msg) {
//        rabbitTemplate.convertAndSend("发送消息：" + msg.get("msg"));
        rabbitTemplate.convertAndSend("emailExchange", "emailRouting", "发送消息：" + msg.get("msg"));
    }

    @Transactional
    public void sendBlog(Map<String, String> msg) {
        String routingKey = msg.get("key");
        rabbitTemplate.convertAndSend("blogExchange", routingKey, msg.get("msg"));
        System.out.println("发布的博客内容：" + msg);
    }

    @Transactional
    public void sendHeadersMessage(Map<String, String> params) {
        String msg = params.get("msg");
        MessageProperties messageProperties = new MessageProperties();
        if (!StringUtils.isEmpty(params.get("token"))) {
            messageProperties.setHeader("token", params.get("token"));
        }
        if (!StringUtils.isEmpty(params.get("id"))) {
            messageProperties.setHeader("id", params.get("id"));
        }
        Message message = new Message(msg.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("headersExchange", null, message);
        System.out.println("通过headers发布内容：" + msg);
    }
}
