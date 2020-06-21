package anxiuze.biz.productor.bizproductor.proxyTest.student;

/**
 * @author anxiuze
 * @date 2020/4/21 10:58
 * @Description:
 */
public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        //假设上交学费的动作总耗时一秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交学费50元！");
    }
}
