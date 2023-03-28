/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.array;

import java.util.ArrayList;

/**
 * BM98 螺旋矩阵
 *
 * @author shenzui5233
 * @since 2023-03-28
 */
public class SpiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down) {
                return res;
            }
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                return res;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) {
                return res;
            }
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                return res;
            }
        }
        return res;
    }
}
