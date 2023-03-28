/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.dp;

/**
 * BM62 斐波那契数列
 *
 * @author shenzui5233
 * @since 2023-03-28
 */
public class Fibonacci {
    /**
     * fib(1) = 1; fib(2) = 1;
     * fib(x) = fib(x - 1) + fib(x - 2)
     *
     * @param n number
     * @return int
     */
    public int fibonacci(int n) {
        if (n <= 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
