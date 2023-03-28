/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.str;

/**
 * BM84 最长公共前缀
 *
 * @author shenzui5233
 * @since 2023-03-25
 */
public class LongestCommonPrefix {

    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int counter = 0;
        while (counter < strs[0].length()) {
            for (String str : strs) {
                if (str.length() <= counter || strs[0].charAt(counter) != str.charAt(counter)) {
                    return strs[0].substring(0, counter);
                }
            }
            counter++;
        }
        return strs[0];
    }

    public static void main(String[] args) {
        // test case
        // "" "d"
        // "da" "ad"

        String[] strs = new String[] {
          "a", "al"
        };
        System.out.println(longestCommonPrefix(strs));
    }
}
