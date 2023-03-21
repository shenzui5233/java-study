/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class DuplicateLinkedList1 {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 快慢指针
        // slow每次加1直到链表结束
        // fast在slow基础上，当遇到重复值时加1，直到fast+1与slow不同或链表结束
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null) {
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
            if (slow != null) {
                fast = slow.next;
            }
        }
        return head;
    }
}

@AllArgsConstructor
@NoArgsConstructor
class ListNode {
    int val;

    ListNode next = null;
}
