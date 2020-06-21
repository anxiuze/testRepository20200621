package anxiuze.biz.productor.bizproductor.proxyTest.student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author anxiuze
 * @date 2020/4/21 11:20
 * @Description:
 */
public class StudentProxyTest {

    public static void main(String[] args) {

        //创建一个实体类对象，这个对象是被动态代理的对象
        Person tom = new Student("Tom");

        //创建一个与代理对象相关的InvocationHandler
        InvocationHandler stuInvocationHandler = new StuInvocationHandler<Person>(tom);

        //创建一个代理对象stuProxy来代理tom，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), tom.getClass().getInterfaces(), stuInvocationHandler);
        stuProxy.giveMoney();

    }


}
