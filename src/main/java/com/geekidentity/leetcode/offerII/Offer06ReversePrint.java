package com.geekidentity.leetcode.offerII;

/**
 * 链表
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Offer06ReversePrint {
    public int[] reversePrint(ListNode head) {
        int size = size(head);
        int[] result = new int[size];
        ListNode cur = head;
        while (cur != null) {
            result[--size] = cur.val;
            cur = cur.next;
        }
        return result;
    }

    private int size(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
