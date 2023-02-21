/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

/**
 * 冒泡排序
 * 找到0到i间的最大元素放入到最右边的位置nums[i]中: 不断交换相邻元素以选取最大元素
 *
 * @author shenzui5233
 * @since 2023-02-21
 */
public class BubbleSortDemo implements ImmutableSorter {
    @Override
    public void sort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}
