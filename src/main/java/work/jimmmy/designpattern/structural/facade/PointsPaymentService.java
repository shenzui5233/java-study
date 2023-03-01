/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.facade;

/**
 * 积分支付子系统
 *
 * @author shenzui5233
 * @since 2023-02-28
 */
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        // 扣减积分
        System.out.println("支付" + pointsGift.getGame() + "积分成功");
        return true;
    }
}
