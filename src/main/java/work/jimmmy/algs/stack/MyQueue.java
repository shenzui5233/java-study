/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.stack;

import java.util.Stack;

/**
 * 通过两个栈实现队列
 *
 * @author shenzui5233
 * @since 2023-03-22
 */
public class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop(); // 栈为空时执行pop方法会抛EmptyStackException运行时异常
        }
    }
}
