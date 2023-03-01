/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.decorator.v1;

/**
 * 煎饼加蛋加肠
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class CakeWithEggSausage extends CakeWithEgg {
    @Override
    public String getDesc() {
        return super.getDesc() + "加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
