/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.proxy.staticproxy;

import work.jimmmy.designpattern.structural.proxy.IOrderService;
import work.jimmmy.designpattern.structural.proxy.Order;
import work.jimmmy.designpattern.structural.proxy.OrderServiceImpl;
import work.jimmmy.designpattern.structural.proxy.db.DataSourceContextHolder;

import javax.xml.crypto.Data;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class OrderServiceStaticProxy {
    private IOrderService service = new OrderServiceImpl();

    public int saveOrder(Order order) {
        beforeMethod();
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db" + dbRouter + "】处理数据");
        // 设置datasource
        afterMethod();
        return service.saveOrder(order);
    }

    private void beforeMethod() {
        System.out.println("静态代理 before code");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }
}
