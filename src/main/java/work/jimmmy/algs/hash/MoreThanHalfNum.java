/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * BM51 数组中出现次数超过一半的数字
 *
 * @author shenzui5233
 * @since 2023-03-25
 */
public class MoreThanHalfNum {
    public int moreThanHalfNum(int [] array) {
        Map<Integer, Integer> map = new HashMap<>(); // 值，次数
        for (int number : array) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }
        for(Integer key : map.keySet()) {
            if (map.get(key) > array.length / 2) {
                return key;
            }
        }
        return 0;
    }
}
