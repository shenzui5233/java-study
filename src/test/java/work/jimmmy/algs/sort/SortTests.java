/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序算法测试类
 *
 * @author shenzui5233
 * @since 2023-02-21
 */
public class SortTests {
    @Test
    public void test_insertionSort() {
        sortTest(InsertionSortDemo.class, 100000);
    }

    @Test
    public void test_selectionSort() {
        sortTest(SelectionSortDemo.class, 100000);
    }

    @Test
    public void test_bubbleSort() {
        sortTest(BubbleSortDemo.class, 100000);
    }

    @Test
    public void test_mergeSort() {
        sortTest(MergeSortDemo.class, 100000);
    }

    public void sortTest(Class cls, int n) {
        try {
            MutableSorter is = (MutableSorter) cls.newInstance();
            int[] nums = gen(n).stream().mapToInt(x -> x).toArray();
            long start = System.currentTimeMillis();
            is.sort(nums);
            System.out.println("time usage " + (System.currentTimeMillis() - start));
            assertSorted(nums);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void assertSorted(int[] nums) {
        assertSorted(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    static void assertSorted(List<Integer> nums) {
        int p = Integer.MIN_VALUE;
        for (int num : nums) {
            if (p > num) {
                System.out.println(nums);
                Assert.fail("Array not in sorted order");
            }
            p = num;
        }
    }

    static List<Integer> gen(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add((int) (Math.random() * n));
        }
        return nums;
    }
}
