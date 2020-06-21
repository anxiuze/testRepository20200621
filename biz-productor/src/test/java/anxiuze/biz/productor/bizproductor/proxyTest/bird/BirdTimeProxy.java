package anxiuze.biz.productor.bizproductor.proxyTest.bird;

/**
 * @author anxiuze
 * @date 2020/4/21 14:26
 * @Description:
 */
public class BirdTimeProxy implements Flyable {

    Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        Long start = System.currentTimeMillis();

        flyable.fly();

        Long end = System.currentTimeMillis();

        System.out.println("fly time = " + (end - start));

    }
}
