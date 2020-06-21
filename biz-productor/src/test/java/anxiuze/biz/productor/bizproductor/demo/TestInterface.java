package anxiuze.biz.productor.bizproductor.demo;

/**
 * @author anxiuze
 * @date 2020/4/16 10:41
 * @Description:
 */
public interface TestInterface {

    void test();


    public static void main(String[] args) {
        TestInterface testInterface = new TestInterface() {
            @Override
            public void test() {
                System.out.println("1111111");
            }
        };

        testInterface.test();
    }

}
