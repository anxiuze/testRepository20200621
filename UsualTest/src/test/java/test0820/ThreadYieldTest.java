package test0820;

import org.junit.Test;

public class ThreadYieldTest {
    public static void main(String[] args) {
        MyThreadYield myThreadYield = new MyThreadYield();
        Thread thread1 = new Thread(myThreadYield, "AAA");
        Thread thread2 = new Thread(myThreadYield, "BBB");
        thread1.start();
        thread2.start();
    }

    /**
     * join()的作用是：“等待该线程终止”
     * */
    @Test
    public void testJoin() {
        MyJoin myJoin = new MyJoin();

        Thread thread = new Thread(myJoin);
        thread.start();
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

/**
 * Thread.yield() 方法，使当前线程由执行状态，变成为就绪状态，让出cpu时间，在下一个线程执行时候，此线程有可能被执行，也有可能没有被执行
 */
class MyThreadYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行！");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "执行结束！");
    }
}

class MyJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("线程VIP" + i);
        }
    }
}

