/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

/**
 * 合并两个有序的链表
 *
 * @author shenzui5233
 * @since 2023-03-22
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curt = dummy;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                curt.next = node1;
                node1 = node1.next;
            } else {
                curt.next = node2;
                node2 = node2.next;
            }
            curt = curt.next;
        }
        curt.next = node1 == null ? node2 : node1;
        return dummy.next;
    }
}
