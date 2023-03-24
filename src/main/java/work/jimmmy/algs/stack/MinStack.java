/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.stack;

import java.util.Stack;

/**
 * BM43 包含min函数的栈
 *
 * @author shenzui5233
 * @since 2023-03-25
 */
public class MinStack {
    private final Stack<Integer> numberStack = new Stack<>();

    /**
     * 再使用一个栈维护最小值的记录
     */
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        numberStack.push(node);
        if (minStack.isEmpty() || node <= minStack.peek()) {
            minStack.push(node);
        }
    }

    public void pop() {
        int number = numberStack.pop();
        if (number == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return numberStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
