package test1010;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author anxiuze
 * @date 2020/10/10 11:16
 * @Description:
 */
public class ThreadLocalTest {

    @Test
    public void test01() {
        //新建一个ThreadLocal
        ThreadLocal<String> local = new ThreadLocal<>();
        //新建一个随记类
        Random random = new Random();
        //使用java8的Stream创建5个线程
        IntStream.range(0, 5).forEach(a -> new Thread(() -> {
            //为每个线程设置相应的local值
            local.set(a + "" + random.nextInt(10));

        }));


    }


}
