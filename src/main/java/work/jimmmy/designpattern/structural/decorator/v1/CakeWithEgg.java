/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.decorator.v1;

/**
 * 加蛋煎饼
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class CakeWithEgg extends Cake {
    @Override
    public String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
