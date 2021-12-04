package com.geekidentity.leetcode.offer.backtracking;

/**
 * 搜索与回溯算法
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class Offer54KthLargest {
    private int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return this.result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            return;
        }

        dfs(root.right);
        if (--this.k == 0) {
            this.result = root.val;
        }

        dfs(root.left);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
