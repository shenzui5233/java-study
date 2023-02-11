/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.flowcontrol;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 *
 * @author shenzui5233
 * @since 2023-02-11
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // main线程结束，cyclicBarrier的run方法由最后一个完成的线程执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            // 所有await执行后，会执行该方法
            System.out.println(Thread.currentThread().getName() + ": 所有人都到场了，大家统一触发");
        });
        for (int i = 0; i < 5; i++) {  // 将i的最大值改为10时，可以测试可重用，即，每满5个触发一次
            new Thread(new Task(i, cyclicBarrier)).start();
        }
        System.out.println(Thread.currentThread().getName() + ": flag");
    }

    static class Task implements Runnable {
        private final int id;

        private final CyclicBarrier cyclicBarrier;

        Task(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "__线程" + id + "现在前往集合地点");
            try {
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(Thread.currentThread().getName() + "__线程" + id + "到了集合地点，开始等待其他人到达");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}