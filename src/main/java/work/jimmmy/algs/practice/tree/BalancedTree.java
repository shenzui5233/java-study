/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.tree;

/**
 * 平衡二叉树的判断
 *
 * @author shenzui5233
 * @since 2023-03-17
 */
public class BalancedTree {
    private int height;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            height = 0;
            return true;
        }
        if (!isBalanced(root.left)) {
            return false;
        }
        int leftHeight = height;
        if (!isBalanced(root.right)) {
            return false;
        }
        int rightHeight = height;
        height = Math.max(leftHeight, rightHeight) + 1;
        return Math.abs(leftHeight - rightHeight) <= 1;
    }
}
