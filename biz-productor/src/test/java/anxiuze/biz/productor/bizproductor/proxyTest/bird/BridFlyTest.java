package anxiuze.biz.productor.bizproductor.proxyTest.bird;

/**
 * @author anxiuze
 * @date 2020/4/21 14:22
 * @Description:
 */
public class BridFlyTest {

    public static void main(String[] args) {

        Bird bird = new Bird();

        BirdTimeProxy timeProxy = new BirdTimeProxy(bird);
        BirdLogProxy logProxy = new BirdLogProxy(timeProxy);
        logProxy.fly();
    }

}
