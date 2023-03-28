/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.dp;

/**
 * BM63 跳台阶
 *
 * @author shenzui5233
 * @since 2023-03-28
 */
public class JumpFloor {
    /**
     * f(1) = 1; f(2) = 2; f(3) = 3; f(4) = 5; f(5) = 8; f(6) = 13; f(7) = 21
     *
     * @param target target
     * @return ways
     */
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
