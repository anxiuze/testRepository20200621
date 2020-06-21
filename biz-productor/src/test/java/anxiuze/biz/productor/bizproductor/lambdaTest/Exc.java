package anxiuze.biz.productor.bizproductor.lambdaTest;

/**
 * @author anxiuze
 * @date 2020/4/16 14:02
 * @Description:
 */
public class Exc {

    public static void main(String[] args) {
        int result = 0;
        ReturnOneParam returnOneParam1 = a -> doubleNum(a);
        result = returnOneParam1.method(3);
        System.out.println(result);

        ReturnOneParam returnOneParam2 = Exc::doubleNum;
        result = returnOneParam2.method(5);
        System.out.println(result);

        ReturnOneParam returnOneParam3 = new Exc()::addTow;
        result = returnOneParam3.method(9);
        System.out.println(result);

    }

    public static int doubleNum(int a){
        return a*2;
    }

    public int addTow(int a){
        return a+2;
    }

}
