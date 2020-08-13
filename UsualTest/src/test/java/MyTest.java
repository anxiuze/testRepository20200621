import org.junit.Test;
import test0810.Person;

import java.util.*;

/**
 * @author anxiuze
 * @date 2020/8/4 17:03
 * @Description:
 */
public class MyTest {


    /**
     * 字符串数组去重，并统计相同字符串的个数
     */
    @Test
    public void test() {
        String[] names = new String[]{"Tom", "Jerry", "Kobe", "Kobe", "James", "Curry", "Tom"};

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }
        System.out.println(map);
    }

    /**
     * i++ 和 ++i原理
     * i++ 后加加，原理是：先自增，然后返回自增之前的值
     * ++i 前加加，原理是：先自增，然后返回自增后的值
     * 重点：这是一般人所不知道的，记住：不论是前++还是后++，都有个共同点是先自增。
     * 对于 i++ 的原理，代码模拟其原理，如下：
     * int temp = i;
     * i = i + 1;
     * return temp;
     */
    @Test
    public void test1() {

        int a = 0;
        for (int i = 0; i < 1; i++) {
            a = a++;
        }
        System.out.println(a);
    }

    @Test
    public void test2() {

        int a = 0;
        int b = 0;
        for (int i = 0; i < 1; i++) {
            a = a++;
            b = a++;
        }
        System.out.println(a);
        System.out.println(b);
    }


    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort() {
        int[] arr = new int[]{2, 24, 13, -1, 0, 34, 8};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     */
    @Test
    public void selectSort() {
        int[] arr = new int[]{2, 24, 13, -1, 0, 34, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        String str1 = "bcdbataen";
        String str2 = "ac";
        int result = minLength(str1, str2);
        System.out.println("最小字符串长度：" + result);

        String first = "They are students.";
        String second = "aeiou";
        String newString = deleteSub(first, second);
        System.out.println("删除后的字符串：" + newString);

    }

    public static int minLength(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[] map = new int[256];

        for (int i = 0; i < char2.length; i++) {
            map[char2[i]]++;
        }
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int match = char2.length;
        while (right != char1.length) {
            map[char1[right]]--;
            if (map[char1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[char1[left]] < 0) {
                    map[char1[left++]]++;
                }
                minLength = Math.min(minLength, right - left + 1);
                map[char1[left++]]++;
                match++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
     * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
     */
    public static String deleteSub(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String[] s1 = str1.split("");
            StringBuilder sb = new StringBuilder();
            for (String s : s1) {
                if (!str2.contains(s)) {
                    sb.append(s);
                }
            }
            return sb.toString();
        } else {
            return null;
        }
    }

    /**
     * 3.
     * 题目：打印出所有的 “水仙花数 “，所谓 “水仙花数 “是指一个三位数，其各位数字立方和等于该数本身。
     * 例如：153是一个 “水仙花数 “，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    @Test
    public void test01() {
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = ((i - ge) % 100) / 10;
            int bai = ((i - (ge + (shi * 10))) % 1000) / 100;
            if ((ge * ge * ge + (shi) * (shi) * (shi) + (bai) * (bai) * (bai)) == i) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void test02() {
        Person p1 = new Person("Tom", 34);
        Person p2 = new Person("Tom", 34);
        System.out.println(p1.equals(p2));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);

        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);
        System.out.println(set);
    }


}
