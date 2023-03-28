/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.str;

import java.util.Objects;

/**
 * BM88 判断是否为回文字符串
 *
 * @author shenzui5233
 * @since 2023-03-25
 */
public class Palindrome {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge (String str) {
        if (str == null) {
            return false;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (!Objects.equals(str.charAt(left++), str.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
}
