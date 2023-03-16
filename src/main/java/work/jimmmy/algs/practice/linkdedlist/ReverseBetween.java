/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.linkdedlist;

/**
 * BM2 链表内指定区间反转
 *
 * @author shenzui5233
 * @since 2023-03-16
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = Reverse.init(new int[] {1, 2, 3, 4, 5});
        Reverse.print(head);
        Reverse.print(reverseBetween(head, 2, 4));
        ListNode head1 = Reverse.init(new int[] {5});
        Reverse.print(head1);
        Reverse.print(reverseBetween(head1, 1, 1));
    }

    /**
     * 增加dummyHead避免处理头节点的特殊情况
     * 找到m-1和n+1节点，对n节点到m节点进行反转，结束后，将m-1节点的next指向n节点
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode after = find(dummy, n + 1);
        ListNode before = find(dummy, m - 1);
        ListNode prev = after;
        ListNode curt = before.next;
        ListNode next;
        while (curt != after) {
            next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        before.next = prev;
        return dummy.next;
    }

    public static ListNode find(ListNode head, int n) {
        int counter = 0;
        ListNode curt = head;
        while (curt != null && counter++ < n) {
            curt = curt.next;
        }
        return curt;
    }
}
