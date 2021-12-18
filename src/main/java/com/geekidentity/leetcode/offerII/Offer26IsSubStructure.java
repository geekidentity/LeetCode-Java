package com.geekidentity.leetcode.offerII;

/**
 * 搜索与回溯算法
 * 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class Offer26IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;;
        if (A != null && B != null) {
            if (A.val == B.val) {
                result = hasTree(A, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }
            if (!result) {
                result = isSubStructure(A.right, B);
            }
        }
        return result;
    }

    private boolean hasTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return hasTree(A.left, B.left) && hasTree(A.right, B.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
