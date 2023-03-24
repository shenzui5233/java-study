/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.tree;

/**
 * BM31 对称的二叉树
 *
 * @author shenzui5233
 * @since 2023-03-24
 */
public class Symmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return symmetricalTree(pRoot.left, pRoot.right);
    }

    /**
     * 同时进行遍历，走到应该一致的节点上，判断root1和应该与其对称的root2节点是否对称
     * 1.节点同时为空 true
     * 2.若不同时为空或值不相等，则false
     * 3.节点自身满足对称，那么子树是否对称，即将root1.left和root2.right传入判断对称，反之也是
     *
     * @param root1 节点
     * @param root2 与root1节点位置对称的节点
     * @return 判断节点与子树是否对称
     */
    boolean symmetricalTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        // 同时进行遍历，走到应该一致的节点上，判断root1
        return symmetricalTree(root1.left, root2.right) && symmetricalTree(root1.right, root2.left);
    }
}
