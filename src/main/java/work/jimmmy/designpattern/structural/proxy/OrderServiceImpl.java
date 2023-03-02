/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.proxy;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class OrderServiceImpl implements IOrderService {
    private IOrderDao orderDao = new OrderDaoImpl();

    @Override
    public int saveOrder(Order order) {
        System.out.println("Service层调用Dao层添加Order");
        return orderDao.insert(order);
    }
}
