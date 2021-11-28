package com.geekidentity.leetcode.offer.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 搜索与回溯算法
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class Offer32IIILevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode>[] level = new Stack[2];
        level[0] = new Stack<>();
        level[1] = new Stack<>();
        int cur = 0, next = 1;
        level[cur].push(root);
        while (!level[0].isEmpty() || !level[1].isEmpty()) {
            Stack<TreeNode> stack = level[cur];
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = level[cur].pop();
                list.add(node.val);
                if (cur == 0) {
                    if (node.left != null) {
                        level[next].push(node.left);
                    }
                    if (node.right != null) {
                        level[next].push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        level[next].push(node.right);
                    }
                    if (node.left != null) {
                        level[next].push(node.left);
                    }
                }

            }
            result.add(list);
            cur = 1 - cur;
            next = 1 - next;
        }
        return result;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
