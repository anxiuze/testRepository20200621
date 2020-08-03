package test0803;

/**
 * @author anxiuze
 * @date 2020/8/3 21:51
 * @Description: 单例模式
 */
public class Singleton {

    //构造方法私有化
    private Singleton() {
    }

    //1.饿汉式: 类加载时就完成了初始化，类加载较慢，但获取对象速度快
    /*private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }*/

    //2. 懒汉式（非线程安全）
    /*private static Singleton singleton;
    public static Singleton getInstance(){
        if (singleton == null){
            singleton new Singleton();
        }
        return singleton;
    }*/

    //3.懒汉式（线程安全）
    /**
     * 这种写法能够在多线程中很好的工作，但是每次调用getInstance方法时都需要进行同步，造成不必要的同步开销，而且大部分时候我们是用不到同步的，所以不建议用这种模式。
     */
    /*private static Singleton singleton;
    public static synchronized Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }*/

    //4.懒汉式（双重检查模式）
    /**这种写法在getSingleton方法中对singleton进行了两次判空，第一次是为了不必要的同步，第二次是在singleton等于null的情况下才创建实例。在这里用到了volatile关键字
     * 在这里使用volatile会或多或少的影响性能，但考虑到程序的正确性，牺牲这点性能还是值得的。
     * DCL优点是资源利用率高，第一次执行getInstance时单例对象才被实例化，效率高。缺点是第一次加载时反应稍慢一些，在高并发环境下也有一定的缺陷，虽然发生的概率很小。
     * 在《java并发编程实践》一书建议用静态内部类单例模式来替代DCL
     * */
    /*private volatile static Singleton singleton;

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    //5.静态内部类单例模式

    /**
     * 第一次加载Singleton类时并不会初始化sInstance，只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance ，
     * 这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
     */
    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    public static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

}
