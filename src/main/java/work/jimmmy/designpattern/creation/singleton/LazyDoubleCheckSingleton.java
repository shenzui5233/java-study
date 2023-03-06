/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.creation.singleton;

/**
 * 双重检查
 *
 * @author shenzui5233
 * @since 2023-03-02
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton(); // 由于重排序问题，有可能在其他线程看来，先给instance了，但是还没初始化完成
                    // 当前线程顺序：1。分配
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
