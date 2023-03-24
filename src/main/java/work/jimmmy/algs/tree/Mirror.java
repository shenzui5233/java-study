/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.tree;

/**
 * BM33 二叉树的镜像
 *
 * @author shenzui5233
 * @since 2023-03-24
 */
public class Mirror {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode left = mirror(pRoot.left);
        pRoot.left = mirror(pRoot.right);
        pRoot.right = left;
        return pRoot;
    }
}
