package test0901;

/**
 * @author anxiuze
 * @date 2020/9/3 16:02
 * @Description:
 */
public class VolatileTest {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int n = 0; n < 1000; n++) {
                    increment(count);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(count);
    }

    private static void increment(int count) {
        count++;
    }

}
