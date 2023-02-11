/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.flowcontrol;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition使用示例
 *
 * @author shenzui5233
 * @since 2023-02-11
 */
public class ConditionDemo {
    private final ReentrantLock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.releaseCondition();
        }).start();
        demo.waitCondition();
    }

    void waitCondition() {
        lock.lock();
        try {
            System.out.println("条件不满足，开始await");
            condition.await();
            System.out.println("条件满足，开始执行后续任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void releaseCondition() {
        lock.lock();
        try {
            System.out.println("准备工作完成，唤醒其他的线程");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
