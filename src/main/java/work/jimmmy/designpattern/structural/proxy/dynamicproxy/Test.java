/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.proxy.dynamicproxy;

import work.jimmmy.designpattern.structural.proxy.IOrderService;
import work.jimmmy.designpattern.structural.proxy.Order;
import work.jimmmy.designpattern.structural.proxy.OrderServiceImpl;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-02
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        IOrderService orderServiceDynamicProxy =
            (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderServiceDynamicProxy.saveOrder(order);
    }
}
