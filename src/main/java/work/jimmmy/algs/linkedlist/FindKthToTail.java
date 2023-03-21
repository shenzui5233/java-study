/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

/**
 * 链表中倒数最后k个节点
 *
 * @author shenzui5233
 * @since 2023-03-22
 */
public class FindKthToTail {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode kNode = pHead;
        for (int i = 0; i < k; i++) {
            if (kNode == null) {
                return null;
            }
            kNode = kNode.next;
        }
        ListNode curt = pHead;
        while (kNode != null) {
            curt = curt.next;
            kNode = kNode.next;
        }
        return curt;
    }
}
