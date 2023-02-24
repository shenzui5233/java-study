/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author shenzui5233
 * @since 2023-02-22
 */
public class HeapSortDemo implements MutableSorter {
    @Override
    public void sort(int[] nums) {
        heapSort(nums);
    }

    private void heapSort(int[] nums) {
        int length = nums.length;
        buildHeap(nums, length); // 构建大根堆
        System.out.println(Arrays.toString(nums));
        // 依次将堆顶与堆的最后一个元素交换，然后堆长度-1重新生成大根堆（下沉）
        for (int i = length - 1; i > 0 ; i--) {
            swap(nums, 0, i);
            maxHeap(nums, 0, i);
        }
    }

    /**
     * 构建最大堆
     * 从最后一个开始，遍历所有非叶子节点，对每个非叶子节点进行最大堆下沉，逐步构建堆
     *
     * @param nums 数组
     * @param length 数组的长度
     */
    private void buildHeap(int[] nums, int length) {
        int nodeIndex = length / 2 - 1; // 找到最后一个非叶子节点索引
        for (int i = nodeIndex; i >= 0; i--) {
            maxHeap(nums, i, length);
        }
    }

    /**
     * 以rootIndex为根节点，进行最大堆下沉的过程
     *
     * @param nums 数组
     * @param rootIndex 根节点索引
     * @param length 堆在数组的下标边界
     */
    private void maxHeap(int[] nums, int rootIndex, int length) {
        int nodeIndex = rootIndex;
        int leftChild = 2 * nodeIndex + 1;
        int rightChild = 2 * nodeIndex + 2;
        if (leftChild < length && nums[nodeIndex] < nums[leftChild]) {
            nodeIndex = leftChild;
        }
        if (rightChild < length && nums[nodeIndex] < nums[rightChild]) {
            nodeIndex = rightChild;
        }
        if (nodeIndex != rootIndex) {
            swap(nums, rootIndex, nodeIndex);
            maxHeap(nums, nodeIndex, length);
        }
    }
}
