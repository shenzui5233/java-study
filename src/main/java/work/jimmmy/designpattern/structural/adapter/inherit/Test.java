/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.adapter.inherit;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Test {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        target.request();

        Target adpterTarget = new Adapter();
        adpterTarget.request();
    }
}
