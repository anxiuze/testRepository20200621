package test0810;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author anxiuze
 * @date 2020/8/14 16:14
 * @Description: 参考网站： https://blog.csdn.net/anthony_ju/article/details/82078450
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

    @Test
    public void test04() {
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
        //****************************** 过滤 ******************************************
        //filter() 过滤
        List<Student> list = students.stream().filter(student -> "武汉大学".equals(student.getSchool())).collect(Collectors.toList());
        System.out.println(list);

        //distinct，去重
        List<Student> distinctList = students.stream().filter(student -> student.getAge() % 2 == 0).distinct().collect(Collectors.toList());
        System.out.println(distinctList);

        //limit,limit返回包含前n个元素的流，当集合大小小于n时，返回实际长度
        List<Student> limitList = students.stream().filter(student -> "华中科技大学".equals(student.getSchool())).limit(2).collect(Collectors.toList());
        System.out.println(limitList.size());
        System.out.println(limitList);

        //limit 结合 sorted,排序后截取
        List<Student> sortedList = students.stream().filter(student -> "土木工程".equals(student.getMajor())).sorted((s1, s2) -> s1.getAge() - s2.getAge()).limit(3).collect(Collectors.toList());
        System.out.println(sortedList);

        //skip,跳过前n个元素

        List<Student> skipList = students.stream().filter(student -> "土木工程".equals(student.getMajor())).skip(2).collect(Collectors.toList());
        System.out.println(skipList);



    }


}
