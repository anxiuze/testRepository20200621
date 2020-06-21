package anxiuze.biz.productor.bizproductor.simpleTest;

/**
 * @author anxiuze
 * @date 2020/4/1417:09
 * @Description:
 */
public class TestDemo2 {


    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b)); //
        System.out.println(a1.show(c)); //
        System.out.println(a1.show(d));
        System.out.println(a2.show(b));
        System.out.println(a2.show(c));
        System.out.println(a2.show(d));
        System.out.println(b.show(b));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }
}

class A {
    public String show(D obj) { return ("A-D"); }
    public String show(A obj) { return ("A-A"); }
}
class B extends A {
    public String show(B obj) { return ("B-B"); }
    public String show(A obj) { return ("B-A"); }
}
class C extends B { }
class D extends B { }
