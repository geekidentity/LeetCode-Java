package com.geekidentity.leetcode.n0025;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i ++) {
                end = end.next;
            }
            if (end == null) break;;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            ListNode newHead = reverse(start);
            pre.next = newHead;
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
