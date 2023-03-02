/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.proxy.staticproxy;

import work.jimmmy.designpattern.structural.proxy.Order;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-02
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
