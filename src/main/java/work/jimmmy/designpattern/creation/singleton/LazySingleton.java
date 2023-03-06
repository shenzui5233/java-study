/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.creation.singleton;

/**
 * 懒汉式单例模式
 *
 * @author shenzui5233
 * @since 2023-03-02
 */
public class LazySingleton {
    /**
     * 饿汉式在这里直接初始化即可
     */
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    /**
     * 获取实例
     *
     * @return instance
     */
    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
