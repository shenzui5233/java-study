/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {32, 103, 24, 88, 95, 70, 97, 15, 102, 6, 79, 46, 51, 37, 93, 108, 9, 58, 53, 58, 79, 36, 58, 91,
            78, 58, 61, 81};
        System.out.println(Arrays.toString(quickSort(nums, 28)));
    }

    public static int[] quickSort(int[] A, int n) {
        // write code here;
        sort(A, 0, n - 1);
        return A;
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        sort(nums, start, pivot - 1);
        sort(nums, pivot + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = start;
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] >= nums[pivot]) {
                j--;
            }
            while (i < j && nums[i] <= nums[pivot]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, pivot, i);
        pivot = i;
        return pivot;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
