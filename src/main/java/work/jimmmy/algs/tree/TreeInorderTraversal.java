/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeInorderTraversal {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal(TreeNode root) {
        List<Integer> list = traversal(root);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> traversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(traversal(root.left));
        list.add(root.val);
        list.addAll(traversal(root.right));
        return list;
    }
}

class TreeNode {
    int val = 0;

    TreeNode left = null;

    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
