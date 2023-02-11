/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.flowcontrol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量的使用demo
 *
 * @author shenzui5233
 * @since 2023-02-11
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++) {
            es.execute(new Task(semaphore));
        }
        es.shutdown();
    }
}

class Task implements Runnable {
    private final Semaphore semaphore;

    Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "拿到了许可证");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "释放了许可证");
        semaphore.release();
    }
}
