/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.decorator.v2;

/**
 * 香肠
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(AbstractCake cake) {
        super(cake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
