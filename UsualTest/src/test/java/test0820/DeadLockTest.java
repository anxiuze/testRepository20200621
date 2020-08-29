package test0820;

/**
 * @Author: anxiuze
 * @Date: 2020/8/28 23:42
 * @Description: 线程间产生死锁
 * @Version: 1.0
 **/
public class DeadLockTest {

    public static void main(String[] args) {
        MakeUp makeUp = new MakeUp(0, "灰姑娘");
        MakeUp makeUp2 = new MakeUp(1, "白雪公主");
        new Thread(makeUp).start();
        new Thread(makeUp2).start();

    }

}


class LipStick {

}

class Mirror {

}

class MakeUp implements Runnable {

    //需要的资源只有一份，用static保证只有一份
    private static LipStick lipStick = new LipStick();

    private static Mirror mirror = new Mirror();

    //选择的步骤
    private int step;
    //化妆的人
    private String name;

    public MakeUp(int step, String name) {
        this.step = step;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (step == 0) {
            //获得口红的锁
            synchronized (lipStick) {
                System.out.println(this.name + "获得口红的锁！");
                Thread.sleep(1000);

                //1秒钟后获得镜子的锁
                synchronized (mirror) {
                    System.out.println(this.name + "获得镜子的锁");
                }
            }
        } else if (step == 1) {
            //获得镜子的锁
            synchronized (mirror) {
                System.out.println(this.name + "获得镜子的锁！");
                Thread.sleep(2000);

                //2秒钟后获得口红的锁
                synchronized (lipStick) {
                    System.out.println(this.name + "获得口红的锁");
                }
            }
        }
    }

}
