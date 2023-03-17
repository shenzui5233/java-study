/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历：先左子树，再根节点，最后右子树
 *
 * @author shenzui5233
 * @since 2023-03-17
 */
public class InorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list.stream().mapToInt(x -> x).toArray();
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            traversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            traversal(root.right, list);
        }
    }
}
