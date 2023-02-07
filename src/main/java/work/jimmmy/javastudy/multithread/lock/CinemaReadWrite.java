
package work.jimmmy.javastudy.multithread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁示例
 * 读锁可以被多个线程获取，写锁只能被一个线程获取，释放锁后才能被另一个线程获取
 * 插队策略：读锁不允许插队场景；允许读锁插队场景
 */
public class CinemaReadWrite {
    private static final ReentrantReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();

    private static final ReentrantReadWriteLock.ReadLock READ_LOCK = READ_WRITE_LOCK.readLock();

    private static final ReentrantReadWriteLock.WriteLock WRITE_LOCK = READ_WRITE_LOCK.writeLock();

    private static void read(int duration) {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取读锁");
        READ_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁，正在读取");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            READ_LOCK.unlock();
        }
    }

    private static void write(int duration) {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取写锁");
        WRITE_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁，正在写入");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            WRITE_LOCK.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // System.out.println("读写锁demo1: 展示写锁互斥，读锁可以共享的例子");
        // readWriteDemo();
        System.out.println("读写锁demo2: 展示读锁不能插队场景，即线程队列头节点是获取写锁的场景时，新来的获取读锁线程不允许插队");
        readWriteQueueDemo();
    }

    /**
     * 读写锁demo
     * 展示读锁共享,写锁互斥的例子
     */
    public static void readWriteDemo() {
        new Thread(() -> read(1000), "Thread1").start();
        new Thread(() -> read(1000), "Thread2").start();
        new Thread(() -> write(1000), "Thread3").start();
        new Thread(() -> write(1000), "Thread4").start();
    }

    /**
     * 插队策略：队列头节点为获取写锁的线程时，不允许获取读锁的线程插队
     * 起一个线程不断创建获取读锁的线程，
     * 模拟场景1：队列头节点是读线程，此时有新线程来获取读锁，允许读锁插队
     * 模拟场景2：队列头节点是写线程，此时有新线程来获取读锁，不允许读锁插队
     */
    public static void readWriteQueueDemo() {
        new Thread(() -> write(40), "Thread1").start();
        new Thread(() -> read(20), "Thread2").start();
        new Thread(() -> read(20), "Thread3").start();
        new Thread(() -> write(40), "Thread4").start();
        new Thread(() -> read(20), "Thread5").start();
        new Thread(() -> {
            Thread[] threads = new Thread[1000];
            for (int i = 0; i < 1000; i++) {
                threads[i] = new Thread(() -> read(1000), "子线程创建的Thread" + i);
            }
            for (int i = 0; i < 1000; i++) {
                threads[i].start();
            }
        }).start();
    }
}
