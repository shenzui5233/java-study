/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.tree;

/**
 * BM29 二叉树中和为某一值的路径(一)
 *
 * @author shenzui5233
 * @since 2023-03-23
 */
public class HasPathSum {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int target = sum - root.val;
        // 是叶子节点，判断target是否==0
        if (root.left == null && root.right == null) {
            return target == 0;
        }
        // 有左 left
        boolean left = hasPathSum(root.left, target);
        // 有右 right
        boolean right = hasPathSum(root.right, target);
        // return left ｜｜ right
        return left || right;
    }
}
