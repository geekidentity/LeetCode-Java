package com.geekidentity.leetcode.n0103;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean left = true;
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            Deque<Integer> levelQueue = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                if (left) {
                    levelQueue.addLast(node.val);
                } else {
                    levelQueue.addFirst(node.val);
                }
                if (node.left != null) nodeQueue.offer(node.left);
                if (node.right != null) nodeQueue.offer(node.right);
            }
            left = !left;
            result.add(new LinkedList<>(levelQueue));
        }
        return result;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
