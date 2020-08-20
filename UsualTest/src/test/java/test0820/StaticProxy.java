package test0820;

public class StaticProxy {

    public static void main(String[] args) {
        WendingCompany wendingCompany = new WendingCompany(new You());
        wendingCompany.happyMarry();

        //Thread类开启线程的原理同上面的例子
//        Thread thread = new Thread(new Runnable接口的实现类);
//        thread.start();
        //用Lambda表达式的方式开启线程
//        new Thread(()-> System.out.println("开启线程")).start();
    }
}

interface Marry {
    void happyMarry();
}

class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("Tom今天结婚，他很高兴！");
    }
}

class WendingCompany implements Marry {

    private Marry target;

    public WendingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        target.happyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚前，布置现场");
    }

    private void after() {
        System.out.println("结婚后，打扫现场");
    }
}
