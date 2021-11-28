package com.geekidentity.leetcode.offer.doublepointer;

/**
 * 双指针
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class Offer52GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int sizeA = size(headA);
        int sizeB = size(headB);
        int diff = sizeA - sizeB;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else if (diff < 0) {
            for (int i = 0; i < -diff; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
