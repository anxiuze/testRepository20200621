package anxiuze.biz.productor.bizproductor.simpleTest;

/**
 * @author anxiuze
 * @date 2020/4/1416:44
 * @Description:
 */
public class TestDemo {


    public static void main(String[] args) {
       /* String str = "123";
        StringBuffer sb = new StringBuffer("123");
        test(str, sb);
        System.out.println(str);
        System.out.println(sb);*/

        try {
            test3();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test(String str, StringBuffer sb) {
        str = new String(str.concat("4"));
        str.concat("5");
        sb = new StringBuffer(sb.append("4"));
        sb.append("5");
        System.out.println(str);
        System.out.println(sb);

    }

    public static void test() {
        int i = 0;
        int j = i == 0 ? 1 : 2;
        System.out.println(j);
    }

    public static void test2() {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    continue;
                }
                if (j == 2) {
                    break;
                }
                count1++;
            }
            count2++;
        }
        System.out.println(count1 + "," + count2);
    }

    public static void test3() throws Exception {
        try {
            System.out.print("a");
            int i = 0;
            if(i == 0) {
                throw new RuntimeException("g");
            }
            System.out.print("b");
        } catch (RuntimeException e) {
            System.out.print("c");
            throw e;
        } catch (Exception e) {
            System.out.print("d");
            throw e;
        } finally {
            System.out.print("e");
        }
        System.out.print("f");
    }


}
