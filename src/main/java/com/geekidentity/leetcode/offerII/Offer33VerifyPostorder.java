package com.geekidentity.leetcode.offerII;

/**
 * 分治算法
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * 在后续遍历得到的序列中，最后一个数字是树的根节点的值。数组中前面的数字可以分为两部分：
 * 第一部分是左子树节点的值，它们都比根节点的值小；
 * 第二部分是右子树节点的值，它们都比根节点的值大。
 */
public class Offer33VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        // 终止条件： 当 i >= j ，说明此子树节点数量 <= 1 ，无需判别正确性，因此直接返回 true；
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
