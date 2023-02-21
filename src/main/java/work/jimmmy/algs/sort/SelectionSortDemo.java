/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

/**
 * 选择排序
 * 找到0到i间的最大元素放入到最右边的位置nums[i]中
 *
 * @author shenzui5233
 * @since 2023-02-21
 */
public class SelectionSortDemo implements ImmutableSorter {
    @Override
    public void sort(int[] nums) {
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int maxIndex = maxIndex(nums, 0, i + 1);
            swap(nums, i, maxIndex);
        }
    }

    private int maxIndex(int[] nums, int i, int j) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = i;
        for (int k = i; k < j; k++) {
            if (nums[k] >= maxValue) {
                maxValue = nums[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
