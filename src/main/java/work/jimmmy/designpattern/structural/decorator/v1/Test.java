/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.decorator.v1;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Test {
    public static void main(String[] args) {
        Cake cake = new Cake();
        System.out.println(cake.getDesc() + "销售价格:" + cake.cost());

        CakeWithEgg cakeWithEgg = new CakeWithEgg();
        System.out.println(cakeWithEgg.getDesc() + "销售价格:" + cakeWithEgg.cost());

        CakeWithEggSausage cakeWithEggSausage = new CakeWithEggSausage();
        System.out.println(cakeWithEggSausage.getDesc() + "销售价格:" + cakeWithEggSausage.cost());
    }
}
