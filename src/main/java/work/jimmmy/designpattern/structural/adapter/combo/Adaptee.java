/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.adapter.combo;

/**
 * 被适配的类
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Adaptee {
    public void adapteeRequest() {
        System.out.println("被适配者的方法");
    }
}
