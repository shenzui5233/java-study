package work.jimmmy.javastudy.multithread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁示例
 *      读锁可以被多个线程获取，写锁只能被一个线程获取，释放锁后才能被另一个线程获取
 *      插队策略：读锁不允许插队场景；允许读锁插队场景
 */
public class CinemaReadWrite {
    private static final ReentrantReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();

    private static final ReentrantReadWriteLock.ReadLock READ_LOCK = READ_WRITE_LOCK.readLock();

    private static final ReentrantReadWriteLock.WriteLock WRITE_LOCK = READ_WRITE_LOCK.writeLock();

    private static void read() {
        READ_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁，正在读取");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            READ_LOCK.unlock();
        }
    }

    private static void write() {
        WRITE_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁，正在写入");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            WRITE_LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        // readWriteDemo
        readWriteQueueDemo();
    }

    /**
     * 读写锁demo
     *
     * 展示写锁互斥，读锁可以共享的例子
     */
    public static void readWriteDemo() {
        new Thread(CinemaReadWrite::read, "Thread1").start();
        new Thread(CinemaReadWrite::read, "Thread2").start();
        new Thread(CinemaReadWrite::write, "Thread3").start();
        new Thread(CinemaReadWrite::write, "Thread4").start();
    }

    /**
     * 插队策略：队列头节点为获取写锁的线程时，不允许获取读锁的线程插队
     */
    public static void readWriteQueueDemo() {
        new Thread(CinemaReadWrite::write, "Thread1").start();
        new Thread(CinemaReadWrite::read, "Thread2").start();
        new Thread(CinemaReadWrite::read, "Thread3").start();
        new Thread(CinemaReadWrite::write, "Thread4").start();
        new Thread(CinemaReadWrite::read, "Thread5").start();
        /*
            Thread1得到了写锁，正在写入
            Thread1释放写锁
            Thread2得到了读锁，正在读取
            Thread3得到了读锁，正在读取
            Thread2释放读锁
            Thread3释放读锁
            Thread4得到了写锁，正在写入
            Thread4释放写锁
            Thread5得到了读锁，正在读取
            Thread5释放读锁
         */
    }
}
