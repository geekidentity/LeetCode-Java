package com.geekidentity.leetcode.offerII;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 搜索与回溯算法
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * 每次打印一个节点时，如果该节点有子节点，则把该节点的子节点放到一个队列末尾。接下来到队列的头部取出最早进入队列的节点，重复前面的打印操作，
 * 直至队列中所有的节点都被打印出来。
 */
public class Offer32ILevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
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


