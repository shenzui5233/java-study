/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

public class BuyStock2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {8, 9, 2, 5, 4, 7}));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算最大收益
     * 
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profits = 0;
        int cursor = 0;
        while (cursor < prices.length) {
            while (cursor < prices.length && !isTrough(prices, cursor)) {
                cursor++;
            }
            int buyDay = cursor;
            while (cursor < prices.length && !isPeak(prices, cursor)) {
                cursor++;
            }
            int sellDay = cursor;
            if (sellDay > buyDay && sellDay < prices.length) {
                profits += (prices[sellDay] - prices[buyDay]);
            }
        }
        return profits;
    }

    private static boolean isPeak(int[] nums, int x) {
        return (x - 1 < 0 || nums[x - 1] < nums[x]) && (x + 1 >= nums.length || nums[x] >= nums[x + 1]);
    }

    private static boolean isTrough(int[] nums, int x) {
        return (x - 1 < 0 || nums[x - 1] >= nums[x]) && (x + 1 >= nums.length || nums[x] < nums[x + 1]);
    }
}
