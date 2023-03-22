/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

import java.util.Stack;

/**
 * 判断一个链表是否时回文结构
 *
 * @author shenzui5233
 * @since 2023-03-22
 */
public class Pail {
    /**
     * 使用stack作为辅助，判断正序和逆序的值是否相等
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curt = head;
        while (curt != null) {
            stack.push(curt.val);
            curt = curt.next;
        }
        curt = head;
        while (!stack.isEmpty()) {
            if (curt.val != stack.pop()) {
                return false;
            }
            curt = curt.next;
        }
        return true;
    }

    /**
     * 使用stack作为辅助，将链表后半部分入栈，然后依次出栈并与链表的前半部分进行比较
     *
     * @param head head
     * @return boolean
     */
    public boolean isPail2(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        // 双指针找到中间节点 2/N
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHalf = slow.next;
        while (rightHalf != null) {
            stack.push(rightHalf.val);
            rightHalf = rightHalf.next;
        }
        ListNode curt = head;
        while (!stack.isEmpty()) {
            if (curt.val != stack.pop()) {
                return false;
            }
            curt = curt.next;
        }
        return true;
    }

    /**
     * 不依赖额外空间，改造链表。
     * 找到右半区首节点，反转后指向2/N节点。2/节点指向null
     * 对比两个区节点值是否相等直到一侧走到null
     *
     * @param head head
     * @return boolean
     */
    public boolean isPail3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHalf = slow.next;
        rightHalf = reverse(rightHalf, slow);
        slow.next = null;
        ListNode leftHalf = head;
        while (leftHalf != null) {
            if (leftHalf.val != rightHalf.val) {
                return false;
            }
            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node, ListNode last) {
        ListNode curt = node;
        ListNode prev = last;
        ListNode next;
        while (curt != null) {
            next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        return prev;
    }
}
