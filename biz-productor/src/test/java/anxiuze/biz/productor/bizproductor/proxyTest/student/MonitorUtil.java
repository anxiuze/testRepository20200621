package anxiuze.biz.productor.bizproductor.proxyTest.student;

/**
 * @author anxiuze
 * @date 2020/4/21 11:03
 * @Description:
 */
public class MonitorUtil {
    private static ThreadLocal<Long> t1 = new ThreadLocal<>();

    /**
     * @author anxiuze
     * @date 2020/4/21 11:04
     * @Description: 记录方法开始执行时间
     */
    public static void start() {
        t1.set(System.currentTimeMillis());
    }

    /**
     * @author anxiuze
     * @date 2020/4/21 11:07
     * @Description: 计算方法执行过程耗时时间
     */
    public static void costTime(String methodName) {
        Long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时：" + (finishTime - t1.get()) + "毫秒");
    }

}
