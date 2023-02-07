
package work.jimmmy.javastudy.multithread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // printHoldCount()
        accessResource();
    }

    /**
     * 拿到锁后，继续获取该锁，并打印锁当前被持有的数量
     */
    private static void printHoldCount() {
        // 拿到锁后，继续获取该锁
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    /**
     * 递归
     */
    private static void accessResource() {
        lock.lock();
        try {
            System.out.println("已经对资源进行了处理");
            if (lock.getHoldCount() < 5) {
                System.out.println(lock.getHoldCount());
                accessResource();
                System.out.println(lock.getHoldCount());
            }
        } finally {
            lock.unlock();
        }
    }
}
