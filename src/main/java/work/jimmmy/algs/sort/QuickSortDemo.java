/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

import javafx.util.Pair;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 快速排序
 * 选第一个数，将list根据大于小于该数拆分成两块，再依次递归下去，直到list只有一个数，然后合并
 *
 * @author shenzui5233
 * @since 2023-02-21
 */
public class QuickSortDemo {
    public static class QuickSort1 implements ImmutableSorter {

        @Override
        public List<Integer> sort(List<Integer> nums) {
            return quickSort(nums);
        }

        private List<Integer> quickSort(List<Integer> nums) {
            if (nums.size() <= 1) {
                return nums;
            }
            int num = nums.get(0);
            List<Integer> left = nums.stream().filter(x -> x < num).collect(Collectors.toList());
            List<Integer> mid = nums.stream().filter(x -> x == num).collect(Collectors.toList());
            List<Integer> right = nums.stream().filter(x -> x > num).collect(Collectors.toList());
            left = quickSort(left);
            left.addAll(mid);
            left.addAll(quickSort(right));
            return left;
        }
    }

    public static class QuickSort2 implements MutableSorter {

        @Override
        public void sort(int[] nums) {
            // quickSort(nums, 0, nums.length - 1);
            quickSortWithoutRecursion(nums, 0, nums.length - 1);
        }

        private void quickSort(int[] nums, int startIndex, int endIndex) {
            if (nums.length <= 1 || startIndex >= endIndex) { // 区间为1或不存在的场景
                return;
            }
            int pivot = partition2(nums, startIndex, endIndex);
            quickSort(nums, startIndex, pivot - 1);
            quickSort(nums, pivot + 1, endIndex);
        }

        /**
         * 相向双指针
         *
         * @param nums nums
         * @param startIndex 区间起始下标
         * @param endIndex 区间终止下标
         * @return pivot下标
         */
        private int partition1(int[] nums, int startIndex, int endIndex) {
            int pivot = nums[startIndex]; // 选择基准元素
            int i = startIndex;
            int j = endIndex;
            while (i < j) {
                while (i < j && nums[j] >= pivot) {
                    j--;
                }
                while (i < j && nums[i] <= pivot) {
                    i++;
                }
                if (i < j) {
                    swap(nums, i, j);
                }
            }
            swap(nums, startIndex, i);
            return i;
        }

        /**
         * 同向双指针
         *
         * @param nums nums
         * @param startIndex 区间起始下标
         * @param endIndex 区间终止下标
         * @return pivot下标
         */
        private int partition2(int[] nums, int startIndex, int endIndex) {
            int pivot = nums[startIndex];
            int markerIndex = startIndex;
            int cursor = startIndex + 1;
            while (cursor <= endIndex) {
                if (nums[cursor] <= pivot) {
                    swap(nums, ++markerIndex, cursor);
                }
                cursor++;
            }
            swap(nums, startIndex, markerIndex);
            return markerIndex;
        }

        private void quickSortWithoutRecursion(int[] nums, int startIndex, int endIndex) {
            if (nums.length <= 1 || startIndex >= endIndex) { // 区间为1或不存在的场景
                return;
            }
            Stack<Pair<Integer, Integer>> stack = new Stack<>();
            stack.push(new Pair<>(startIndex, endIndex));
            while (!stack.isEmpty()) {
                Pair<Integer, Integer> interval = stack.pop();
                int leftIndex = interval.getKey();
                int rightIndex = interval.getValue();
                int pivotIndex = partition2(nums, leftIndex, rightIndex);
                if (leftIndex < pivotIndex - 1) {
                    stack.push(new Pair<>(leftIndex, pivotIndex - 1));
                }
                if (pivotIndex + 1 < rightIndex) {
                    stack.push(new Pair<>(pivotIndex + 1, rightIndex));
                }
            }
        }
    }
}
