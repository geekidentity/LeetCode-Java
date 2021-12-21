package com.geekidentity.leetcode.offerII;

/**
 * 剑指 Offer 08. 二叉树的下一个节点
 * 题目：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 */
public class Offer08GetNext {

    public TreeNode getNext(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            TreeNode right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else if (node.parent != null) {
            TreeNode current = node;
            TreeNode parent = node.parent;
            while (parent != null && parent.right == current) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
        return null;
    }

    static class TreeNode {
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        int val;
    }
}
