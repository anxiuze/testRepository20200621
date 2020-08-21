package test0820;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author anxiuze
 * @date 2020/8/21 14:01
 * @Description: 参考文章：https://www.cnblogs.com/zincredible/p/10984459.html
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
//        cacheThreadPool();
        fixThreadPool();
    }

    /**
     * @author anxiuze
     * @date 2020/8/21 14:02
     * @Description: 可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     *
     * 创建一个可缓存线程池。若线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（超60秒不执行任务）线程；
     * 当任务数增加时，此线程池又可以智能的添加新的线程来处理任务；
     * 此线程池不会对线程池的大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小
     */
    public static void cacheThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            final int ii = i;
            try {
                /**当有新任务到来，则插入到SynchronousQueue中，由于SynchronousQueue是同步队列，因此会在池中寻找可用线程来执行，
                 * 若有可以线程则执行，若没有可用线程则创建一个线程来执行该任务；若池中线程空闲时间超过指定大小，则该线程会被销毁。*/
                //若将sleep注释，则会创建10个不同的线程来执行任务。若不注释，则会由同一个线程来执行10个任务。
                Thread.sleep(ii * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(() -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii));
        }
        cachedThreadPool.shutdown();
    }

    /**
     * @author anxiuze
     * @date 2020/8/21 14:18
     * @Description: 定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     *
     * 创建固定大小的线程池。每次提交一个任务就新建一个线程，知道线程数达到线程池的最大数量；
     * 线程池的大小一旦到大最大值就会保持不变，若某个线程因为执行异常而结束，那么线程池会补充一个新线程；
     * 因为线程池大小为3，每个任务输出index后sleep2秒，所以没两秒打印3个数字和线程名称
     */
    public static void fixThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(() -> {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        fixedThreadPool.shutdown();
    }
}
