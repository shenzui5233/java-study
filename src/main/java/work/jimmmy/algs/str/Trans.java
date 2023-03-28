/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.str;

import java.util.Stack;

/**
 * BM83 字符串变形
 *
 * @author shenzui5233
 * @since 2023-03-28
 */
public class Trans {
    public static void main(String[] args) {
        System.out.println((char) ('a' - 32));
    }

    public String trans(String s, int n) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        // 遍历，遇到空格则转换大小写，入栈
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                stack.push(" ");
                i++;
            } else {
                int j = i;
                while (j < n && s.charAt(j) != ' ') {
                    j++;
                }
                stack.push(convert(s.substring(i, j)));
                i = j;
            }
        }
        // 全入栈后，依次出栈并拼接上空格
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    private String convert(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                output.append((char) (ch - 32));
            } else if (ch >= 'A' && ch <= 'Z'){
                output.append((char) (ch + 32));
            }
        }
        return output.toString();
    }
}
