package test0810;

import java.util.Comparator;

/**
 * @author anxiuze
 * @date 2020/8/13 13:59
 * @Description: 按照Person的年龄从大到小倒叙排序
 */
public class DescAgePersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge() - o1.getAge();
    }
}
