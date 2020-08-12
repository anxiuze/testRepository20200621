package test0810;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author anxiuze
 * @date 2020/8/12 14:35
 * @Description: Lambda表达式遍历集合
 * 参考：https://www.cnblogs.com/haixiang/p/11029639.html
 */


public class LambdaTest2 {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        //向list中添加元素
        Collections.addAll(list, 1, 3, 5, 6, 7, 8, 9);
        //1.传统方式遍历
       /* for (Integer integer : list) {
            System.out.println(integer);
        }*/
        //Lambda表达式，方法引用
//        list.forEach(System.out::println);

//        list.forEach(element -> System.out.println(element));

        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });

    }

    /**
     * @date 2020/8/12 16:46
     * @Description: 删除集合中的某个元素
     */
    @Test
    public void test02(){

        List<Item> items = new ArrayList<>();
        items.add(new Item(14, "牙刷", BigDecimal.valueOf(5.32)));
        items.add(new Item(12, "毛巾", BigDecimal.valueOf(9.43)));
        items.add(new Item(34, "洗面奶", BigDecimal.valueOf(99.9)));
        items.add(new Item(4, "牙膏", BigDecimal.valueOf(6.00)));

        //传统删除方式
/*
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            if (item.getId() == 12){
                iterator.remove();
            }
        }
*/

        //Lambda表达式方式进行删除
        items.removeIf(item -> item.getId() == 12);

        //通过forEach遍历检查是否正确删除
        items.forEach(System.out::println);

    }

    class Item{
        private Integer id;
        private String name;
        private BigDecimal price;

        public Item(Integer id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    /**
     * @author anxiuze
     * @date 2020/8/12 16:59
     * @Description: 对List中元素进行排序
     * 在以前我们若要为集合内的元素排序，就必须调用 sort 方法，传入比较器匿名内部类重写 compare 方法，我们现在可以使用 lambda 表达式来简化代码
     */
    @Test
    public void test03(){
        List<Item> items = new ArrayList<>();
        items.add(new Item(14, "牙刷", BigDecimal.valueOf(5.32)));
        items.add(new Item(12, "毛巾", BigDecimal.valueOf(9.43)));
        items.add(new Item(34, "洗面奶", BigDecimal.valueOf(99.9)));
        items.add(new Item(4, "牙膏", BigDecimal.valueOf(6.00)));

/*        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getId() - o2.getId();
            }
        });*/

        items.sort((o1,o2) -> o1.getId() - o2.getId());

        items.forEach(System.out::println);


    }




}
