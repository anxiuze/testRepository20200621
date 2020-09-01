package test0901;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anxiuze
 * @date 2020/9/1 16:12
 * @Description: 线程安全解决方案
 */
public class ThreadSafeTest implements Runnable {

    private static Integer count = 1;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        ThreadSafeTest test = new ThreadSafeTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
    }


    @Override
    public void run() {
        while (true) {
//            int count = getCount();
            int count = getCountAtomic();
            //有点疑问，为什么会输出6次呢？？
            System.out.println(count);
            if (count >= 5) {
                break;
            }
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
        System.out.println("result=======>" + result);
        return result;
    }
}
