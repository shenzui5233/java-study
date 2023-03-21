/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class BracketMatch {
    public static void main(String[] args) {
        System.out.println(isValid(")))"));
    }

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !Objects.equals(map.get(ch), stack.pop())) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
