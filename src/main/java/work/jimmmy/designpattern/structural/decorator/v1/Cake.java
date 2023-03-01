/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.decorator.v1;

/**
 * 煎饼
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Cake {
    protected String getDesc() {
        return "煎饼";
    }

    protected int cost() {
        return 8;
    }
}
