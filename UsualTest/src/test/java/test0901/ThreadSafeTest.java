package test0901;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anxiuze
 * @date 2020/9/1 16:12
 * @Description: 线程安全解决方案
 */
public class ThreadSafeTest implements Runnable {

    private static Integer count = 1;

    private volatile static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        ThreadSafeTest test = new ThreadSafeTest();
        Thread t1 = new Thread(test, "t1");
        Thread t2 = new Thread(test, "t2");
        Thread t3 = new Thread(test, "t3");
        t1.start();
        t2.start();
        t3.start();
    }


    @Override
    public void run() {
        while (true) {
//            int count = getCount();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int count = getCountAtomic();
            //这个输出的结果还是有些疑惑的，线程的数目不同，输出的结果不同
            System.out.println(Thread.currentThread().getName() + "------>" + count);
            if (count >= 5) {
                break;
            }
//            System.out.println(Thread.currentThread().getName() + "------>" + count);
        }
    }

    public synchronized Integer getCount() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count++;
    }

    public Integer getCountAtomic() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = atomicInteger.incrementAndGet();
//        System.out.println(Thread.currentThread().getName() + ": result=======>" + result);
        return result;
    }
}
