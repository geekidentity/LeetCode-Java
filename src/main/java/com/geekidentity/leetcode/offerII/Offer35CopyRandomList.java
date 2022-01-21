package com.geekidentity.leetcode.offerII;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 1. 复制原始链表的任意节点N并创建新节点N'，再把N'链接到N的后面。
 * 2. 设置手复制出来的sibling。
 * 3. 把这个长链表拆分成2个链表：把奇数位置的节点用next链接起来就是原始链表，把偶数位置的节点用next链接起来就是复制出的的链表。
 */
public class Offer35CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        cloneNode(head);
        connectSiblingNode(head);
        return reconnectNode(head);
    }

    private Node reconnectNode(Node head) {
        Node newHead = null, curNode = head, curNewNode = null;
        if (head != null) {
            newHead = head.next;
            curNewNode = head.next;
        }

        while (curNode != null) {
            curNewNode = curNode.next;
            curNode.next = curNewNode.next;
            curNode = curNewNode.next;
            if (curNode != null) {
                curNewNode.next = curNode.next;
            }
        }
        return newHead;
    }

    private void connectSiblingNode(Node head) {
        Node cur = head, clonedNode = null, randomNode = null;
        while (cur != null) {
            clonedNode = cur.next;
            randomNode = cur.random;
            if (randomNode != null) {
                clonedNode.random = randomNode.next;
            }
            cur = cur.next.next;
        }
    }

    private void cloneNode(Node head) {
        Node cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            Node clonedNode = new Node(cur.val);
            cur.next = clonedNode;
            clonedNode.next = next;
            cur = next;
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}