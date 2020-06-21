package anxiuze.biz.productor.bizproductor.proxyTest.bird;

import java.util.Random;

/**
 * @author anxiuze
 * @date 2020/4/21 14:19
 * @Description:
 */
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
