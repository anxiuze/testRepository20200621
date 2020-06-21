package anxiuze.biz.productor.bizproductor.lambdaTest;

/**
 * @author anxiuze
 * @date 2020/4/1611:17
 * @Description:
 */
public class LambdaTest {

    public static void main(String[] args) {
        NoReturnMultiParam noReturnMultiParam = (int a, int b) ->{
            System.out.println("a+b="+(a+b));
        };
        noReturnMultiParam.mewthod(2,3);



        NoReturnMultiParam noReturnMultiParam1 = (a, b) -> System.out.println("a+b="+(a+b));
        noReturnMultiParam1.mewthod(6,3);

    }

}
