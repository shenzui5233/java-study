/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

import java.util.List;

public class DuplicateLinkedList2 {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = head.next;
        while (slow.next != null && fast != null) {
            while (fast != null && slow.next.val == fast.val) {
                fast = fast.next;
            }
            if (slow.next.next != fast) {
                slow.next = fast;
            } else {
                slow = slow.next;
            }
            fast = fast == null ? null : fast.next;
        }
        return dummyHead.next;
    }
}
