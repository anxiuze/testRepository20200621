package test0810;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author anxiuze
 * @date 2020/8/14 13:42
 * @Description: Java8新特性Optional
 * 参考:  https://www.jianshu.com/p/d81a5f7c9c4e
 * https://www.cnblogs.com/zhangboyu/p/7580262.html
 */
public class OptionalTest {

    @Test
    public void test01() {
        //抛出 java.util.NoSuchElementException: No value present
        Optional<Person> optional = Optional.empty();
        optional.get();
    }

    @Test
    public void test02() {
        //抛出 java.lang.NullPointerException
        Person person = null;
        Optional<Person> optional = Optional.of(person);
    }

    @Test
    public void test03() {
//        Person person = new Person("Jeryy", 23);
        Person person = null;
        Optional<Person> optional = Optional.ofNullable(person);

        //为避免下面equals时出现空指针异常，可以先判断是否有值
        /*Assert.assertTrue(optional.isPresent());

        Assert.assertEquals(person.getName(), optional.get().getName());*/

        //检查是否有值的另一个选择是 ifPresent() 方法。该方法除了执行检查，还接受一个Consumer(消费者) 参数，
        //如果对象不是空的，就对执行传入的 Lambda 表达式：
        optional.ifPresent(u -> Assert.assertEquals(person.getName(), u.getName()));
    }

    @Test
    public void test04() {
        /**
         * orElse和orElseGet的区别
         * 首先两个都是判断包装对象是否为null,若不为null则返回自身,若为null,则返回指定的默认值
         * 但是orElse无论包装对象是否为null,都会创建默认值;而orElseGet当包装对象非null时,不会再创建默认值,效率相对高一些.
         * */
        Person person = null;
//        Person person = new Person("Jerry",34);
        Person person1 = new Person("Tom", 12);
        //如果person是null，则赋默认值person1，如果person不是null，则保留原值，不赋默认值
        Person result = Optional.ofNullable(person).orElse(person1);
        System.out.println(Optional.ofNullable(person));
        System.out.println("result: " + result);
        Assert.assertEquals(result.getName(), person1.getName());

        //orElseGet() --这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果：
        Person result2 = Optional.ofNullable(person).orElseGet(() -> person1);
        System.out.println(result2);
    }

    @Test
    public void test05() {
        /**filter()*/
        Person person = new Person("Tom", 23);
        Optional.ofNullable(person).filter(p -> p.getAge() > 18).ifPresent(p -> System.out.println("The Person age is more than 18"));
    }


}
