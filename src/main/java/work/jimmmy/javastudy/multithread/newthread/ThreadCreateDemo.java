/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.javastudy.multithread.newthread;

import java.util.concurrent.*;

/**
 * 线程创建
 *
 * @author shenzui5233
 * @since 2023-02-25
 */
public class ThreadCreateDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        Future<?> future = executor.submit(new Task());
        System.out.println(future.get());
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        executor.shutdown();
        // future 本质上是一个存储器，存储了call方法任务的结果。
        // 一个方法的计算耗时，无需等待，用子线程执行。想要结果时，通过future操作实现callable接口的任务
        // future.get获取callable接口返回的执行结果：未执行完毕前会阻塞，直到call方法返回了结果后，get才会得到结果，主线程切换到runnable状态
        // isDone判断任务是否执行完了
        // 取消任务
        // 限时获取任务结果
    }
}

class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(100000);
        return "gogogo";
    }
}
