/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

public class LinkedListReverse {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curt = head;
        ListNode next = null;
        while (curt != null) {
            next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        return prev;
    }
}