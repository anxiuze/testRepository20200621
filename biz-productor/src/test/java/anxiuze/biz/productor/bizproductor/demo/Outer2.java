package anxiuze.biz.productor.bizproductor.demo;

/**
 * @author anxiuze
 * @date 2020/4/1610:26
 * @Description:
 */
public class Outer2 {


    public void func() {
        System.out.println("1");
    }


    public static void main(String[] args) {
        Outer2 inner = new Outer2() {
            public void func() {
                System.out.println("2");
            }
        };
        inner.func();
    }
}
