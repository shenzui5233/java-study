/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历：先根节点，再左子树，再右子树
 *
 * @author shenzui5233
 * @since 2023-03-17
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        if (root == null) {
            return new int[0];
        }
        return traversal(root).stream().mapToInt(x -> x).toArray();
    }

    private List<Integer> traversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left != null) {
            list.addAll(traversal(root.left));
        }
        if (root.right != null) {
            list.addAll(traversal(root.right));
        }
        return list;
    }
}
