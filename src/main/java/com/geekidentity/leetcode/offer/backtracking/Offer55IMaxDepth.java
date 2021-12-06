package com.geekidentity.leetcode.offer.backtracking;

/**
 * 搜索与回溯算法
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * 2 种解题方法
 */
public class Offer55IMaxDepth {
    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root, 0);
        return depth;
    }

    private void depth(TreeNode root, int d) {
        if (root == null) {
            if (d > depth) {
                depth = d;
            }
            return ;
        }
        depth(root.left, d + 1);
        depth(root.right, d + 1);
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
