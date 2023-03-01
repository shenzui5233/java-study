/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.facade;

/**
 * 物流系统
 *
 * @author shenzui5233
 * @since 2023-02-28
 */
public class ShippingService {
    /**
     * 发货
     *
     * @param pointsGift pointsGift
     * @return 订单号
     */
    public String shipGift(PointsGift pointsGift) {
        // 物流系统的对接逻辑
        System.out.println(pointsGift.getGame() + "进入物流系统");
        return "666";
    }
}
