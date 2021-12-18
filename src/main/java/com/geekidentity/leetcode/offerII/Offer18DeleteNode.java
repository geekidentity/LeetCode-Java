package com.geekidentity.leetcode.offerII;

/**
 * 双指针
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Offer18DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0), pre = newHead, cur = head, next = null;
        newHead.next = head;
        while (cur != null) {
            next = cur.next;
            if (cur.val == val) {
                pre.next = next;
                cur = next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return newHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
