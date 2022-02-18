package com.geekidentity.leetcode.offerII;

/**
 * 搜索与回溯算法
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class Offer36TreeToDoublyList {
    private Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 当 pre 为 null 时，代表正在访问 链表头结点，记为 head。
     * 当 pre 不为 null 时，修改双向链表引用，即： pre.right = cur; cur.left = pre。
     * 保存 cur：更新 pre = cur，即节点 cur 是后继节点的 pre；
     */
    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (head == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
