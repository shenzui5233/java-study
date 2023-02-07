package work.jimmmy.javastudy.multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 描述： 演示AtomicIntegerFieldUpdater的用法
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {
    static Candidate tom;

    static Candidate peter;

    public static final AtomicIntegerFieldUpdater<Candidate> SCORE_UPDATER
            = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score++;
            SCORE_UPDATER.getAndIncrement(tom); // 对tom使用scoreUpdater包装后，对其socre属性进行原子操作
        }
    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdaterDemo r = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通变量：" + peter.score);
        System.out.println("升级后变量：" + tom.score);
    }

    public static class Candidate {
        /**
         * 不可将变量定义为private或static
         */
        volatile int score;
    }
}
