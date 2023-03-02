/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.proxy;

/**
 * 订单DAO
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public interface IOrderDao {
    int insert(Order order);
}
