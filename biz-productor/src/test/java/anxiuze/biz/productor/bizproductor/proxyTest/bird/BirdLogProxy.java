package anxiuze.biz.productor.bizproductor.proxyTest.bird;

/**
 * @author anxiuze
 * @date 2020/4/21 14:25
 * @Description:
 */
public class BirdLogProxy implements Flyable {

    Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");
        flyable.fly();
        System.out.println("Bird fly end...");

    }
}
