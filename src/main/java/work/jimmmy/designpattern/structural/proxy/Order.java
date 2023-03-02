/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.proxy;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
@Getter
@Setter
public class Order {
    private Object orderInfo;
    private Integer userId;
}
