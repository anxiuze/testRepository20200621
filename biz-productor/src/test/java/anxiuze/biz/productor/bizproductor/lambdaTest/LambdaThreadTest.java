package anxiuze.biz.productor.bizproductor.lambdaTest;

/**
 * @author anxiuze
 * @date 2020/4/16 14:22
 * @Description:
 */
public class LambdaThreadTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread-" + Thread.currentThread().getName());
        });
        thread1.start();

        System.out.println("=============================");

        Runnable runnable = () -> {
            String arg = Thread.currentThread().getName();
            System.out.println("Thread2++" + arg);
        };
        runnable.run();
        Thread thread2 = new Thread(runnable);
        thread2.start();


    }


}
