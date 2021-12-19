package com.geekidentity.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * 分治算法
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 原理：先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
 */
public class Offer07BuildTree {
    private int[] preorder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root  先序遍历的索引
     * @param left  中序遍历的索引
     * @param right 中序遍历的索引
     */
    private TreeNode recur(int root, int left, int right) {
        // 终止条件： 当 left > right ，代表已经越过叶节点，此时返回 nullnull ；
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]);
        node.left = recur(root + 1, left, i - 1);
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        node.right = recur(root + (i - left + 1), i + 1, right);
        return node;
    }

    static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
