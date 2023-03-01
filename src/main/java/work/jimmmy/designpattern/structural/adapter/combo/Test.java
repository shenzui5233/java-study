/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.adapter.combo;

/**
 * 适配器模式
 * 和装饰者模式区别：应用层是否使用新的接口和方法调用。
 *  适配器模式用于适配新的接口，通过新的接口和方法引用被适配的类
 *  装饰者模式基于原有的接口，增强原有实现的能力
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Test {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
