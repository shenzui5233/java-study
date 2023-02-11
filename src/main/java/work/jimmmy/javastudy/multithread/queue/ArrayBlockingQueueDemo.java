/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 有界阻塞队列demo
 *
 * @author shenzui5233
 * @since 2023-02-11
 */
public class ArrayBlockingQueueDemo {
    private static final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

    /**
     * 生产者消费者，interviewee作为生产者，向阻塞队列添加；Interviewer作为消费者，从阻塞队列取数据
     *
     * @param args args
     */
    public static void main(String[] args) {
        new Thread(new Interviewee(queue)).start();
        new Thread(new Interviewer(queue)).start();
    }
}

/**
 * 被面试者，作为生产者
 */
class Interviewee implements Runnable {
    BlockingQueue<String> queue;

    public Interviewee(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("10个候选人都来了");
        for (int i = 0; i < 10; i++) {
            String candidate = "Candidate" + i;
            try {
                queue.put(candidate);
                System.out.println("安排好了:" + candidate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put("stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 面试官，作为消费者
 */
class Interviewer implements Runnable {
    BlockingQueue<String> queue;

    public Interviewer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String msg;
            while (!"stop".equals(msg = queue.take())) {
                System.out.println(msg + "到了");
            }
            System.out.println("所有候选人都结束了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
