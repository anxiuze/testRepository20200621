package test0820;

/**
 * @author anxiuze
 * @date 2020/8/26 15:52
 * @Description: 参考：https://www.cnblogs.com/fnlingnzb-learner/p/10335662.html
 *
 * 总结：
 * A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；
 *    如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
 * B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
 * C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        //两个线程持有同一个对象的锁，两个线程互斥，要等前一个线程执行完释放锁后第二个线程才能执行
        SyncThread syncThread = new SyncThread();
//        Thread syncThread1 = new Thread(syncThread, "syncThread1");
//        Thread syncThread2 = new Thread(syncThread, "syncThread2");
//        syncThread1.start();
//        syncThread2.start();

        //两个线程持有两个不同对象的锁，因此互不干涉，两个线程可以并行执行。
//        Thread syncThread1 = new Thread(new SyncThread(), "syncThread1");
//        Thread syncThread2 = new Thread(new SyncThread(), "syncThread2");
//        syncThread1.start();
//        syncThread2.start();

        //当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块
//        Counter counter = new Counter();
//        Thread thread1 = new Thread(counter, "A");
//        Thread thread2 = new Thread(counter, "B");
//        thread1.start();
//        thread2.start();

        Account account = new Account("Tom", 1000);
        AccountOperator accountOperator = new AccountOperator(account);
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(accountOperator, "Thread-" + i);
            threads[i].start();

        }
    }
}

/**
 * @author anxiuze
 * @date 2020/8/26 16:05
 * @Description: 同步代码块，被synchronized修饰的代码块，在多线程环境下不能并行执行
 */
class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " : " + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * @author anxiuze
 * @date 2020/8/26 16:04
 * @Description: 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。
 */
class Counter implements Runnable {

    public int count;

    public Counter() {
        count = 0;
    }

    public void countAdd() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " : " + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void countPrint() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "->" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if ("A".equals(threadName)) {
            this.countAdd();
        } else if ("B".equals(threadName)) {
            this.countPrint();
        }
    }
}

/**
 * @author anxiuze
 * @date 2020/8/26 17:11
 * @Description: 在AccountOperator 类中的run方法里，我们用synchronized 给account对象加了锁。
 * 这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，直到该线程访问account对象结束。
 */
class Account {
    private String name;

    private double amount;

    public Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    //存钱
    public void deposit(double amt) {
        try {
            amount += amt;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //取钱
    public void withDraw(double amt) {
        try {
            amount -= amt;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public double getBalance() {
        return amount;
    }

}

class AccountOperator implements Runnable {

    private Account account;

    //当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁：
    //private byte[] lock = new byte[0]; // 特殊的instance变量
    //说明：零长度的byte数组对象创建起来将比任何对象都经济――查看编译后的字节码：生成零长度的byte[]对象只需3条操作码，而Object lock = new Object()则需要7行操作码。

    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            account.deposit(500);
            account.withDraw(500);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }
}
