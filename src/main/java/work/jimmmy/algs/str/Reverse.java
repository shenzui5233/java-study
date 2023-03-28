/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.str;

/**
 * BM91 反转字符串
 *
 * @author shenzui5233
 * @since 2023-03-25
 */
public class Reverse {
    /**
     * 反转字符串
     * 时间复杂度和空间负载度都是o(n)
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray(); // System.arraycopy(...) 拷贝了一份方法，所以空间复杂度也应该为o(n)
        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            char temp = charArray[i];
            charArray[i++] = charArray[j];
            charArray[j--] = temp;
        }
        return new String(charArray);
    }
}
