/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.flowcontrol;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过condition实现生产者消费者示例
 *
 * @author shenzui5233
 * @since 2023-02-11
 */
public class ProducerConsumerUsingCondition {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        consumer.start();
        producer.start();
    }

    static class BlockingQueue<T> {
        /**
         * 规定队列的最大容量
         */
        private final int queueSize = 10;

        private final LinkedList<T> list = new LinkedList<>();

        private final Lock lock = new ReentrantLock();

        private final Condition notFull = lock.newCondition();

        private final Condition notEmpty = lock.newCondition();

        private T take() {
            lock.lock();
            try {
                while (list.size() == 0) {
                    System.out.println("队列空，等待数据");
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T val = list.remove();
                notFull.signalAll();
                System.out.println("从队列里取走了一个数据，队列剩余" + list.size() + "个元素");
                return val;
            } finally {
                lock.unlock();
            }
        }

        private void put(T val) {
            lock.lock();
            try {
                while (list.size() == queueSize) {
                    System.out.println("队列满，等待有空余");
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(val);
                notEmpty.signalAll();
                System.out.println("向队列里添加了一个数据，队列剩余" + list.size() + "个元素");
            } finally {
                lock.unlock();
            }
        }
    }

    static class Consumer extends Thread {
        private final BlockingQueue<Integer> queue;

        Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                queue.take();
            }
        }
    }

    static class Producer extends Thread {
        private final BlockingQueue<Integer> queue;

        Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            Random random = new Random();
            while (true) {
                queue.put(random.nextInt());
            }
        }
    }
}
