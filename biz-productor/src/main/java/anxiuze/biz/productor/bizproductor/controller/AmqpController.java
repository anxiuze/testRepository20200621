package anxiuze.biz.productor.bizproductor.controller;

import anxiuze.biz.productor.bizproductor.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author anxiuze
 * @date 2020/4/19 10:43
 * @Description:
 */
@RestController
@RequestMapping("/amqp")
public class AmqpController {

    @Autowired
    private AmqpService amqpService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendEmail(@RequestParam Map<String, String> msg) {
        amqpService.sendEmail(msg);
        return "send email over!";
    }

    @GetMapping("/sendBlog")
    public String sendBlog(@RequestParam Map<String, String> msg) {
        amqpService.sendBlog(msg);
        return "send blog over!";
    }

    @GetMapping("/sendHeaders")
    public String sendHeaders(@RequestParam Map<String, String> params) {
        amqpService.sendHeadersMessage(params);
        return "send headers over!";
    }

}
