/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

/**
 * 快速排序
 * 起始：第一个元素作为有序集合，从第二个数起作为新加入的数，插入到有序集合中的恰当位置里
 * 执行：
 *  （1）外层循环：循环执行前，i指向下一个需要排序的元素，下标小于i的元素已经排序完成
 *  （2）内层循环：j指向下一个需要排序元素的插入位置，遍历有序集合寻找该位置
 *
 * @author shenzui5233
 * @since 2023-02-21
 */
public class InsertionSortDemo implements ImmutableSorter {
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) { // i下一个需要排序的元素
            int num = nums[i];
            int j = i; // j 下一个需要排序的元素插入的位置，寻找该位置
            for (; j > 0 && nums[j - 1] > num; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = num;
        }
    }
}
