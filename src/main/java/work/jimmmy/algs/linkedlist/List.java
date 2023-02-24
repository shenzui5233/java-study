/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

import java.util.function.Predicate;

/**
 * 实现链表结构
 *
 * @author shenzui5233
 * @since 2023-02-24
 */
public class List<T> {
    Node<T> head = null;

    /**
     * 头插法
     * O(1)
     *
     * @param data 数据
     */
    public void insert(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    /**
     * 遍历查找node
     * O(n)
     *
     * @param predicate predicate
     * @return node
     */
    public Node<T> find(Predicate<T> predicate) {
        Node<T> p = head;
        while (p != null) {
            if (predicate.test(p.data)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void remove(Node<T> node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            head = head.next;
            return;
        }
        Node<T> slow = head;
        Node<T> fast = head.next;

        while (fast != node && fast != null) {
            slow = fast;
            fast = fast.next;
        }
        if (fast != null) {
            slow.next = fast.next;
            // fast.data = null;
        }
    }

    public int size() {
        Node<T> p = head;
        int c = 0;
        while (p != null) {
            p = p.next;
            c++;
        }
        return c;
    }

    static class Node<T> {
        Node<T> next;

        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
