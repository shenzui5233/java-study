/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.array;

/**
 * BM87 合并两个有序的数组
 *
 * @author shenzui5233
 * @since 2023-03-25
 */
public class Merge {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
