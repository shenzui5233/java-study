
package work.jimmmy.javastudy.multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组使用示例
 * 启动100个线程，每个线程将原子数组的所有元素的值加1
 * 启动100个线程，每个线程将原子数组的所有元素的值减1
 * 查看最后结果：预期，原子数组的每个元素值为0
 */
public class AtomicArrayDemo {
    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        Thread[] threadsIncrementer = new Thread[100];
        Thread[] threadsDecrementer = new Thread[100];
        Incrementer incrementer = new Incrementer(atomicIntegerArray);
        Decrementer decrementer = new Decrementer(atomicIntegerArray);
        // 初始化线程并启动
        for (int i = 0; i < 100; i++) {
            threadsIncrementer[i] = new Thread(incrementer);
            threadsDecrementer[i] = new Thread(decrementer);
            threadsIncrementer[i].start();
            threadsDecrementer[i].start();
        }
        // 等待线程完成
        for (int i = 0; i < 100; i++) {
            try {
                threadsIncrementer[i].join();
                threadsDecrementer[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 检查结果
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            if (atomicIntegerArray.get(i) != 0) {
                System.out.println("发现错误 " + i);
            }
        }
        System.out.println("结束");
    }
}

class Decrementer implements Runnable {
    private final AtomicIntegerArray array;

    public Decrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}

class Incrementer implements Runnable {
    private final AtomicIntegerArray array;

    public Incrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}
