package test0810;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author anxiuze
 * @date 2020/8/13 11:02
 * @Description: Comparable和Comparator比较器两种比较方式
 * 1.Comparable，排序接口
 * 实现Comparable接口，重写compareTo方法，compareTo方法接受任意类型的参数，来进行比较。
 * 若一个类实现Comparable接口，表明该类支持排序，则该类的对象的List列表（或数组）可以通过Collections.sort()（或Arrays.sort()）进行排序
 * 假设通过 x.compareTo(y) 来“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
 * <p>
 * 2.Comparator，比较器接口
 * 自定义比较器，实现Comparator接口，重写compare方法
 * int compare(T o1, T o2) 是“比较o1和o2的大小”。返回“负数”，意味着“o1比o2小”；返回“零”，意味着“o1等于o2”；返回“正数”，意味着“o1大于o2”
 * <p>
 * 若使用Comparable进行比较，则原需要实现此接口，重写compareTo方法；
 * 而使用Comparator自定义比较器时，原类无需做任何改动，只需要单独定义一个比较器实现此接口，重写compare方法
 */
public class ComparableAndComparatorTest {
    List<Person> list = new ArrayList<>();

    @Before
    public void before() {
        Person p1 = new Person("aaa", 12);
        Person p2 = new Person("abc", 23);
        Person p3 = new Person("AAA", 34);
        Person p4 = new Person("bbb", 30);
        Person p5 = new Person("BBB", 56);

        Collections.addAll(list, p1, p2, p3, p4, p5);

    }

    @Test
    public void test01() {
        System.out.println("排序前的list：" + list);
        Collections.sort(list);
        System.out.println("排序后的list：" + list);
    }

    @Test
    public void test02() {
        System.out.println("排序前的list：" + list);
        Collections.sort(list, new AscAgePersonComparator());
        System.out.println("按照年龄从小到大排序后的list：" + list);
    }

    @Test
    public void test03() {
        System.out.println("排序前的list：" + list);
        Collections.sort(list, new DescAgePersonComparator());
        System.out.println("按照年龄从大到小排序后的list：" + list);
    }


}
