package test0901;

/**
 * @author anxiuze
 * @date 2020/9/9 17:10
 * @Description:
 */
public class VolatileTest2 {

    private static boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            preparing();
        }, "t1").start();

        new Thread(() -> {
            successful();
        }, "t2").start();
    }

    private static void preparing() {
        System.out.println("preparing data....");
        while (true) {
            if (flag) {
                System.out.println("finished======!");
                break;
            }
        }
    }

    private static void successful() {
        flag = true;
        System.out.println("successful!");
    }


}
