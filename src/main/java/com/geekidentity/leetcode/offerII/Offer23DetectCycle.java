package com.geekidentity.leetcode.offerII;

/**
 * 链表
 * 剑指 Offer II 022. 链表中环的入口节点
 * 链表中环的入口节点
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * https://leetcode-cn.com/problems/c32eOV/
 */
public class Offer23DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode missingNode = hasCycle(head);
        if (missingNode == null) return null;
        int count = 1;
        ListNode temp = missingNode.next;
        while (temp != missingNode) {
            count++;
            temp = temp.next;
        }
        ListNode first = head, second = head;
        for (int i = 0; i < count; i++) {
            second = second.next;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public ListNode hasCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
