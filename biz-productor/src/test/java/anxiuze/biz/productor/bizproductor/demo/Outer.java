package anxiuze.biz.productor.bizproductor.demo;

/**
 * @author anxiuze
 * @date 2020/4/169:20
 * @Description:
 */
public class Outer {
    private int num = 1;

    public class Inner {
        private int num = 2;
        private void func () {
            System.out.println(Outer.this.num);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.func();
    }

}
