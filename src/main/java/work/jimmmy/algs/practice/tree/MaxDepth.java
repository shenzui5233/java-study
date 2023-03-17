/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.tree;

/**
 * 二叉树的最大深度
 * 深度/高度：二叉树的最大层数
 *
 * @author shenzui5233
 * @since 2023-03-17
 */
public class MaxDepth {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
