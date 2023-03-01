/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.decorator.v2;

/**
 * 抽象装饰者
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class AbstractDecorator extends AbstractCake {
    private AbstractCake cake;

    public AbstractDecorator(AbstractCake cake) {
        this.cake = cake;
    }

    @Override
    protected String getDesc() {
        return this.cake.getDesc();
    }

    @Override
    protected int cost() {
        return this.cake.cost();
    }
}
