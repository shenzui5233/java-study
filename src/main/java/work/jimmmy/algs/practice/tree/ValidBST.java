/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断是不是二叉搜索树
 * 二叉搜索树：每个节点的左子树上的所有节点均小于当前节点，且右子树上的所有节点均大于当前节点
 *
 * @author shenzui5233
 * @since 2023-03-17
 */
public class ValidBST {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST1 (TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public int max = Integer.MIN_VALUE;

    public boolean isValidBST (TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val < max) {
            return false;
        }
        max = root.val;
        return isValidBST(root.right);
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            traversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            traversal(root.right, list);
        }
    }
}
