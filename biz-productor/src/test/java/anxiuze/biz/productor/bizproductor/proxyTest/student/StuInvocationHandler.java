package anxiuze.biz.productor.bizproductor.proxyTest.student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author anxiuze
 * @date 2020/4/21 11:02
 * @Description:
 */
public class StuInvocationHandler<T> implements InvocationHandler {
    //要被代理的类
    private Object object;

    public StuInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     * proxy: 代表动态代理账号
     * method: 代表正在执行的方法
     * args: 代表调用目标方法时传入的实参
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");

        //调用method的invoke方法，等于代理类调用委托类中相关方法
        //可以在调用实体类方法前后加上自定义的方法。AOP的实现原理同此
        //在此添加一个方法监控的方法
        MonitorUtil.start();
        Object obj = method.invoke(object, args);
        MonitorUtil.costTime(method.getName());
        return obj;
    }
}
