package test0810;

/**
 * @author anxiuze
 * @date 2020/8/12 14:11
 * @Description: 通过Lambda表达式来创建线程
 */
public class CreatThreadByLambda {

    public static void main(String[] args) {
        String mainThreadName = Thread.currentThread().getName();
        System.out.println("mainThreadName is :" + mainThreadName);

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("通过匿名内部类的方式创建线程");
                String threadName = Thread.currentThread().getName();
                System.out.println("currentThreadName is :" + threadName);
            }
        };
        thread.start();


        Thread thread1 = new Thread(() -> {
            System.out.println("通过Lambda表达式的方式创建线程");
            Thread.currentThread().setName("lambdaThreadName");
            String lambdaThreadName = Thread.currentThread().getName();
            System.out.println("lambdaThreadName is: " + lambdaThreadName);
        });

        thread1.start();

    }


}
