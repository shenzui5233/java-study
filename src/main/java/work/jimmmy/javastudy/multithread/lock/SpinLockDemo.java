
package work.jimmmy.javastudy.multithread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁样例
 */
public class SpinLockDemo {
    /**
     * 原子引用
     */
    private final AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
            // System.out.println(Thread.currentThread().getName() + "自旋获取失败，再次尝试");
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLock = new SpinLockDemo();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
            spinLock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了自旋锁");
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
