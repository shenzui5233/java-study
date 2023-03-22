/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

/**
 * 两个链表的第一个公共节点
 *
 * @author shenzui5233
 * @since 2023-03-22
 */
public class FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode curt1 = pHead1;
        ListNode curt2 = pHead2;
        // 若不相交，两个链表同时走到null，也相等，能跳出循环
        while (curt1 != curt2) {
            curt1 = curt1 == null ? pHead2 : curt1.next;
            curt2 = curt2 == null ? pHead1 : curt2.next;
        }
        return curt1;
    }
}
