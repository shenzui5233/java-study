/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.flowcontrol;

import java.util.*;

/**
 * 使用Object.wait/notifyAll实现生产者消费者模式
 *
 * @author shenzui5233
 * @since 2023-02-11
 */
public class ProducerConsumerUsingObject {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        consumer.start();
        producer.start();
    }

    static class BlockingQueue<T> {
        private final int queueSize = 10;

        private final LinkedList<T> list = new LinkedList<>();

        private final Object lock = new Object();

        private T take() {
            synchronized (lock) {
                // 如果队列为空，则阻塞等待
                while (list.size() == 0) {
                    System.out.println("队列空，等待数据");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                T val = list.remove();
                lock.notifyAll();
                System.out.println("从队列里取走了一个数据，队列剩余" + list.size() + "个元素");
                return val;
            }
        }

        private void put(T val) {
            synchronized (lock) {
                // 如果队列满了，则阻塞等待
                while (list.size() == queueSize) {
                    System.out.println("队列满，等待有空余");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(val);
                lock.notifyAll();
                System.out.println("从队列里添加了一个数据，队列剩余" + list.size() + "个元素");
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
