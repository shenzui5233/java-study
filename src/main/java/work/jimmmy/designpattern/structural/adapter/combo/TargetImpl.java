/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.adapter.combo;

/**
 * 适配目标类
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class TargetImpl implements Target {
    @Override
    public void request() {
        System.out.println("target目标方法");
    }
}
