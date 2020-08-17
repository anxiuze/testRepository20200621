package test0810;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author anxiuze
 * @date 2020/8/14 16:14
 * @Description:
 */
public class StreamTest {

    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "tom", "jerry", "curry", "james", " ", "john", "tony");
        List<String> filtered = list.stream().filter(s -> (!s.isEmpty() && s.trim().length() > 0)).collect(Collectors.toList());
        System.out.println("过滤前: " + list);
        System.out.println("过滤后: " + filtered);
    }

    @Test
    public void test02() {
        //Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void test03() {
        //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> list = Arrays.asList(1, 3, 5, 5, -5, 6, 7, 8);
        List<Integer> integerList = list.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("原list: " + list);
        System.out.println("list平方去重后: " + integerList);
    }



}
