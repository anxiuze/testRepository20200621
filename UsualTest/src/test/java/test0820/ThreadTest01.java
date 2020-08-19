package test0820;

/**
 * @author anxiuze
 * @date 2020/8/19 15:04
 * @Description: 多线程练习
 */
public class ThreadTest01 {

    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();
        Thread thread1 = new Thread(ticketDemo);
        Thread thread2 = new Thread(ticketDemo);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

}

class TicketDemo implements Runnable {
    //总票数
    private int ticket = 200;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出票编号：" + ticket--);
                }
            }
        }
    }
}
