package work.jimmmy.javastudy.multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的基本用法
 */
public class MustUnlock {
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        } finally {
            LOCK.unlock();
        }
    }
}
