package work.jimmmy.javastudy.multithread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        // sample1(); // 两个线程，使用自己的SimpleDateFormat打印
        // sample2(); // 30个线程，计算日期
        // sample3(); // 1000个打印日期任务，线程池实现, 每个线程使用自己的SimpleDateFormat对象
        // sample4(); // 所有线程共用SimpleDateFormat, 该实现会因为sdf的线程安全问题而出现重复日期
        sample5(); // 所有线程共用SimpleDateFormat, 该实现会因为sdf的线程安全问题而出现重复日期，通过加锁解决
    }

    /**
     * 两个线程，使用自己的SimpleDateFormat打印
     */
    public static void sample1() {
        new Thread(() -> System.out.println(Main.date(10))).start();
        new Thread(() -> System.out.println(Main.date(104707))).start();
    }

    /**
     * 30个线程，计算日期
     */
    public static void sample2() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> System.out.println(Main.date(finalI))).start();
            Thread.sleep(100);
        }
    }

    /**
     * 1000个打印日期任务，线程池实现
     * 每个线程使用自己的SimpleDateFormat对象
     */
    public static void sample3() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            es.execute(() -> System.out.println(Main.date(finalI)));
        }
        es.shutdown();
    }

    /**
     * 所有线程共用SimpleDateFormat
     * 该实现会因为sdf的线程安全问题而出现重复日期
     */
    public static void sample4() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            Date date = new Date(1000 * i);
            es.execute(() -> System.out.println(Main.SIMPLE_DATE_FORMAT.format(date)));
        }
        es.shutdown();
    }

    /**
     * 所有线程共用SimpleDateFormat
     * 该实现会因为sdf的线程安全问题而出现重复日期，通过加锁解决
     */
    public static void sample5() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            es.execute(() -> System.out.println(Main.dateWithLock(finalI)));
        }
        es.shutdown();
    }

    /**
     * 计算距离1970年1月1日 00:00:00 seconds秒后的日期
     *
     * @param seconds seconds
     * @return 格式化后的日期
     */
    public static String date(int seconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // Date构造器单位是毫秒
        return sdf.format(new Date(1000L * seconds));
    }

    /**
     * 计算距离1970年1月1日 00:00:00 seconds秒后的日期(线程安全版本)
     *
     * @param seconds seconds
     * @return 格式化后的日期
     */
    public static String dateWithLock(int seconds) {
        // Date构造器单位是毫秒
        Date date = new Date(1000L * seconds);
        String dateStr;
        synchronized (Main.class) {
            dateStr = SIMPLE_DATE_FORMAT.format(date);
        }
        return dateStr;
    }
}
