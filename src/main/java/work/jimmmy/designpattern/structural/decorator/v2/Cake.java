/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.decorator.v2;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Cake extends AbstractCake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
