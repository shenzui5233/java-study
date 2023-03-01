/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.facade;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Main {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("T-Shirt");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointsGift);
    }
}
