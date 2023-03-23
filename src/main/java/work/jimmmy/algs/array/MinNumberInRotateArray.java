/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.array;

/**
 * 旋转数组的最小值
 *
 * @author shenzui5233
 * @since 2023-03-23
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        // 旋转数组会分为两个有序的子数组
        // 左边数组的最小值[0] >= 右边数组的最大值[length-1]，利用该特性进行二分查找
        // 如果[mid]==[right]时，无法判断最小值在哪一边，但是能明确的是最小值一定在[right]的左侧，所以right--进行下一轮查找
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) { // mid在左侧数组，最小值在mid+1, right区间中
                left = mid + 1;
            } else if (array[mid] < array[right]) { // mid在右侧数组，最小值在left，mid区间中
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }

    public int forceMinNumberInRotateArray(int [] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                minIndex = i + 1;
                break;
            }
        }
        return array[minIndex];
    }
}
