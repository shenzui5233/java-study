/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.tree;

/**
 * 二叉搜索树
 *
 * @author shenzui5233
 * @since 2023-02-24
 */
public class BSTree<T extends Comparable<T>> {
    private BSTNode<T> root;

    static class BSTNode<T> {
        BSTNode<T> left;

        BSTNode<T> right;

        T data;

        public BSTNode(T data) {
            this.data = data;
        }
    }

    private void add(BSTNode<T> node, BSTNode<T> element) {
        if (element.data.compareTo(node.data) <= 0) {
            if (node.left == null) {
                node.left = element;
                return;
            }
            add(node.left, element);
        } else {
            if (node.right == null) {
                node.left = element;
                return;
            }
            add(node.right, element);
        }
    }

    public void add(T element) {
        BSTNode<T> node = new BSTNode<>(element);
        if (root == null) {
            root = node;
            return;
        }
        add(root, node);
    }
}
