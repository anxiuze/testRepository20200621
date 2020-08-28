package test0820;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author anxiuze
 * @date 2020/8/28 15:14
 * @Description: 使用阿里巴巴推荐的通过ThreadPoolExecutor来创建线程池
 */
public class ThreadPoolTest2 {
    //核心线程数：5
    private static final int CORE_POOL_SIZE = 5;
    //最大线程数：10
    private static final int MAX_POOL_SIZE = 10;
    //任务队列容量：100
    private static final int QUEUE_CAPACITY = 100;
    //空闲线程等待时间1秒
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建MyThreadPoolTest对象
            Runnable worker = new MyThreadPoolTest("" + i);
            //执行Runnable
            threadPoolExecutor.execute(worker);
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
        }
        System.out.println("Finished all threads!");
    }
}

class MyThreadPoolTest implements Runnable {

    private String command;

    public MyThreadPoolTest(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始...Time = " + new Date());
        process();
        System.out.println(Thread.currentThread().getName() + "结束...Time = " + new Date());


    }

    public void process() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
