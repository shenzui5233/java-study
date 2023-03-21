/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 完全二叉树判断
 *
 * @author shenzui5233
 * @since 2023-03-17
 */
public class CompleteTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean notComplete = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                notComplete = true;
                continue;
            }
            if (notComplete) {
                return false;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;
    }
}
