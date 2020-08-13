package test0810;

import java.util.Comparator;

/**
 * @author anxiuze
 * @date 2020/8/13 13:53
 * @Description: 按照Person的年龄从小到大顺序排序
 */
public class AscAgePersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
