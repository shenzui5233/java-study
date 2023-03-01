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
public class Test {
    public static void main(String[] args) {
        AbstractCake cake = new Cake();
        cake = new EggDecorator(cake);
        cake = new EggDecorator(cake);
        cake = new SausageDecorator(cake);
        System.out.println(cake.getDesc() + ", 销售价格:" + cake.cost());
    }
}
