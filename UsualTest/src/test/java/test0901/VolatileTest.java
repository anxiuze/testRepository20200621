package test0901;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.concurrent.TimeUnit;

/**
 * @author anxiuze
 * @date 2020/9/3 16:02
 * @Description:
 */
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        Count test = new Count();
        Thread[] threads = new Thread[2];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int mm = 0; mm < 10000; mm++) {
                    test.increment();

                }
            });
            threads[i].start();
            TimeUnit.MILLISECONDS.sleep(50);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(test.getCount());

        //如下代码有问题
        Work work = new Work();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                work.doWork();
            }).start();
            if (i == 5) {
                new Thread(work::shutDown).start();
            }
        }
    }


    static class Count {
        private int count = 0;

        public int getCount() {
            return count;
        }

        private void increment() {
            count++;
        }

    }


    static class Work {

        private volatile boolean isShutDown = false;

        void doWork() {
            while (!isShutDown) {
                System.out.println("machine is running!");
            }

        }

        void shutDown() {
            System.out.println("shutDown......");
            isShutDown = true;
        }
    }

}
