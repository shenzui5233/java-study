/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.flowcontrol;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch示例
 * - 一等多
 * - 多等一
 *
 * @author shenzui5233
 * @since 2023-02-11
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // demo1(); // 一个线程等待多个线程执行完毕，再继续自己的工作
        demo2(); // 多个运动员等裁判喊开始
    }

    public static void demo1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            es.execute(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("No." + finalI + "完成了检查");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        System.out.println("等待5个人检查完");
        latch.await();
        System.out.println("所有人都完成了工作，进入下一个环节。");
        es.shutdown();
    }

    public static void demo2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            es.execute(() -> {
                try {
                    System.out.println("运动员" + finalI + "等待比赛开始");
                    countDownLatch.await();
                    System.out.println("运动员" + finalI + "起跑");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(10000);
        System.out.println("裁判员：准备！");
        countDownLatch.countDown();
        System.out.println("裁判员：跑");
    }
}
