package com.geekidentity.leetcode.offerII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 搜索与回溯算法
 * 剑指 Offer 37. 序列化二叉树
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Offer37SerializableBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        String rootStr = vals[0];
        if (rootStr.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootStr));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(vals[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if (!"null".equals(vals[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}