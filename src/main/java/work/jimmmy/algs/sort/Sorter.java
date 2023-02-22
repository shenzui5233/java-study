/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

/**
 * 排序接口
 *
 * @author shenzui5233
 * @since 2023-02-21
 */
public interface Sorter {
    default void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
