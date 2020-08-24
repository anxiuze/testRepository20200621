package test0820;

public class ThreadYieldTest {
    public static void main(String[] args) {
        MyThreadYield myThreadYield = new MyThreadYield();
        Thread thread1 = new Thread(myThreadYield, "AAA");
        Thread thread2 = new Thread(myThreadYield, "BBB");
        thread1.start();
        thread2.start();
    }
}

/**
 * Thread.yield() 方法，使当前线程由执行状态，变成为就绪状态，让出cpu时间，在下一个线程执行时候，此线程有可能被执行，也有可能没有被执行
 * */
class MyThreadYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行！");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "执行结束！");
    }
}
