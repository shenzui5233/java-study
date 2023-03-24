/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * BM37 二叉搜索树的最近公共祖先
 *
 * @author shenzui5233
 * @since 2023-03-24
 */
public class LowestCommonAncestor {
    /**
     * 分别找出两个节点值在bst查找的路径，然后对比两个路径，最后一个相同的值为最近公共祖先
     *
     * @param root TreeNode类
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        List<Integer> pPath = getPath(root, p);
        List<Integer> qPath = getPath(root, q);
        int res = -1;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (Objects.equals(qPath.get(i), pPath.get(i))) {
                res = qPath.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    private List<Integer> getPath(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        TreeNode node = root;
        while (node.val != target) {
            path.add(node.val);
            if (target < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node.val);
        return path;
    }

    /**
     * 使用递归的方式进行查找
     *
     * @param root bst根节点
     * @param p 第一个节点的值
     * @param q 第二个节点的值
     * @return target
     */
    public int lowestCommonAncestor1 (TreeNode root, int p, int q) {
        int target1 = Math.min(p, q);
        int target2 = Math.max(p, q);
        if (root.val < target1) {
            return lowestCommonAncestor1(root.right, target1, target2);
        } else if (root.val > target2) {
            return lowestCommonAncestor1(root.left, target1, target2);
        } else {
            return root.val;
        }
    }
}
