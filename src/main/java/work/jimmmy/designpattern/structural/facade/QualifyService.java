/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.facade;

/**
 * 积分校验子系统
 *
 * @author shenzui5233
 * @since 2023-02-28
 */
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("校验" + pointsGift.getGame() + " 积分资格通过");
        return true;
    }
}
