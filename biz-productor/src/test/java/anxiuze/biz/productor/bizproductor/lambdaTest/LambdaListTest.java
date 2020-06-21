package anxiuze.biz.productor.bizproductor.lambdaTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author anxiuze
 * @date 2020/4/16 15:17
 * @Description:
 */
public class LambdaListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 3, 5, 6, 7, 10);
        list.forEach(ii -> {
            if (ii % 2 == 0) {
                System.out.println("这个是偶数" + ii);
            }
        });


        // Java字符串替换指定位置的字符 (将ip中的66，替换为111)
        String url = "http://10.1.66.99:27845/claimDetail/openDetailPage.htm?key=20200411110049072716";

        StringBuffer sb = new StringBuffer(url);
        sb.replace(12,14,"111"); // 含左不含右，范围是[12,14)
        System.out.println(sb); //http://10.1.111.99:27845/claimDetail/openDetailPage.htm?key=20200411110049072716


    }


}
