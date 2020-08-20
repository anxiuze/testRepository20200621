package test0820;

import java.util.concurrent.*;

public class ThreadCallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest1 = new CallableTest();
        CallableTest callableTest2 = new CallableTest();
        CallableTest callableTest3 = new CallableTest();

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> future1 = service.submit(callableTest1);
        Future<Boolean> future2 = service.submit(callableTest2);
        Future<Boolean> future3 = service.submit(callableTest3);
        //获取结果
        Boolean r1 = future1.get();
        Boolean r2 = future2.get();
        Boolean r3 = future3.get();
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);

        //关闭服务
        service.shutdown();

    }

}

class CallableTest implements Callable<Boolean> {


    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + "第" + i + "条记录");
        }
        return true;
    }
}
