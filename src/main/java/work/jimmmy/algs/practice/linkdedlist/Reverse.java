/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.practice.linkdedlist;

/**
 * 反转链表
 *
 * @author shenzui5233
 * @since 2023-03-16
 */
public class Reverse {
    public static void main(String[] args) {
        ListNode head = init(new int[] {1, 2, 3, 4, 5});
        print(head);
        print(reverseList(head));
        ListNode head1 = init(new int[] {1});
        print(head1);
        print(reverseList(head1));
        ListNode head2 = init(new int[0]);
        print(head2);
        print(reverseList(head2));
        ListNode head3 = init(null);
        print(head3);
        print(reverseList(head3));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curt = head;
        ListNode next;
        // (1) 记录next (2) curt.next改为指向prev (3) prev和curt往下挪一个：prev赋值为curt，curt赋值为next节点，作为下一次的prev和curt
        while (curt != null) {
            next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        return prev;
    }

    public static ListNode init(int[] nums) {
        if (nums == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curt = dummy;
        for (int num : nums) {
            curt.next = new ListNode(num);
            curt = curt.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode curt = head;
        while (curt != null) {
            stringBuilder.append(curt.val).append(" -> ");
            curt = curt.next;
        }
        stringBuilder.append("null");
        System.out.println(stringBuilder);
    }
}
