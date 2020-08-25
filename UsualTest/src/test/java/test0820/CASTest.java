package test0820;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anxiuze
 * @date 2020/8/25 17:13
 * @Description: 探索CAS乐观锁和Synchronized悲观锁
 */
public class CASTest {
    //声明一个共享变量
//    private static int count;
//    private static AtomicInteger count = new AtomicInteger(0);
    private volatile static int count;

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int n = 0; n < 100; n++) {
                        //1.通过悲观锁synchronized的方式保证线程安全
                       /* synchronized (CASTest.class) {
                            count++;
                        }*/
                        //2.通过原子性操作保证线程安全。某种场景下效率要高于悲观锁的方式
//                       count.incrementAndGet();
                        //3. 通过加volatile保证线程间变量可见性也能保证线程安全；
                        count++;
                    }
                }
            }.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

}
