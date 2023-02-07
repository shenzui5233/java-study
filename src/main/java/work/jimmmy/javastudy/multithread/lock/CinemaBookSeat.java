
package work.jimmmy.javastudy.multithread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟多个线程来预定同一个座位的电影票，锁阻止线程同时预定
 */
public class CinemaBookSeat {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
    }

    private static void bookSeat() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 开始预定座位");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 完成预定座位");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
