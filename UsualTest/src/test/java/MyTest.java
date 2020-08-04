import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anxiuze
 * @date 2020/8/4 17:03
 * @Description:
 */
public class MyTest {


    /**字符串数组去重，并统计相同字符串的个数*/
    @Test
    public void test(){
        String[] names = new String[]{"Tom","Jerry","Kobe","Kobe","James","Curry","Tom"};

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)){
                map.put(name,map.get(name)+1);
            }else {
                map.put(name,1);
            }
        }
        System.out.println(map);
    }

    @Test
    public void test1(){

    }

}
