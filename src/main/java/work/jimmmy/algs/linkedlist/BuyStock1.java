/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

public class BuyStock1 {
    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int buyDay = 0;
        int sellDay = 1;
        int maxProfit = 0;
        while (sellDay < prices.length) {
            int profit = prices[sellDay] - prices[buyDay];
            if (profit < 0) {
                buyDay++;
            } else {
                sellDay++;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
