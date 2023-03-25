/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * BM50 两数之和
 *
 * @author shenzui5233
 * @since 2023-03-25
 */
public class TwoSum {
    /**
     * 倒排索引的思想存入hashmap
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[0];
    }
}
