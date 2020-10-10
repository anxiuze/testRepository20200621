package test0901;

import java.util.Calendar;

/**
 * @author anxiuze
 * @date 2020/9/16 22:28
 * @Description:
 */
public class ParentAndChildTest {

    public static void main(String[] args) {
        ChildrenClass childrenClass = new ChildrenClass();
        ChildrenClass.staticMethod();
        childrenClass.method();
    }
}

class ParentClass {
    public ParentClass() {
        System.out.println("A");
    }

    public static void staticMethod() {
        System.out.println("B");
    }

    public void method() {
        System.out.println("C");
    }
}

class ChildrenClass extends ParentClass {
    public ChildrenClass() {
        System.out.println("X");
    }

    public static void staticMethod() {
        System.out.println("Y");
    }

    public void method() {
        System.out.println("Z");
    }

}