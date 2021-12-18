package com.geekidentity.leetcode.offerII;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 搜索与回溯算法
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class Offer34PathSum {
    private final List<List<Integer>> result = new ArrayList<>();

    private final Deque<Integer> stack = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        findPath(root, target);
        return result;
    }

    private void findPath(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        stack.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<>(stack));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        stack.pollLast();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
