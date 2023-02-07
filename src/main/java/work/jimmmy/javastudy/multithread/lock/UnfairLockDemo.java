
package work.jimmmy.javastudy.multithread.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockDemo {

    public static void main(String[] args) throws InterruptedException {
        PrintQueue pq = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(pq));
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
            Thread.sleep(100);
        }
    }
}

class Job implements Runnable {
    PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始打印");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName() + "打印完毕");
    }
}

class PrintQueue {
    /**
     * true：公平锁，线程0第一次打印完后，让出，线程1的第一次打印执行
     * false：非公平锁，线程0第一次打印完后，由于其他线程在获取锁的队列中，而正在执行的线程0也要获取锁，发生插队，线程0的第二次打印优先执行
     */
    private final Lock queueLock = new ReentrantLock(true);   // true：公平锁，线程0第一次打印完后，让出，线程1的第一次打印执行

    public void printJob(Object document) {
        queueLock.lock();
        try {
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + " 正在打印，需要" + duration);
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try {
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + " 正在打印，需要" + duration);
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}