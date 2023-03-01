/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.adapter.combo;

/**
 * 适配器
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Adapter implements Target {
    public Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        // 其他代码
        adaptee.adapteeRequest();
        // 其他代码
    }
}
