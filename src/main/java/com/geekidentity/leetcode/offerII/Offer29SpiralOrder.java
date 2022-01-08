package com.geekidentity.leetcode.offerII;

/**
 * 模拟
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Offer29SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, top = 0, buttom = matrix.length - 1, x = 0;
        int[] result = new int[(right + 1) * (buttom + 1)];
        while (true) {
            for (int i = left; i <= right; i ++) result[x++] = matrix[top][i];
            if (++top > buttom) break;

            for (int i = top; i <= buttom; i ++) result[x++] = matrix[i][right];
            if (--right < left) break;

            for (int i = right; i >= left; i --) result[x++] = matrix[buttom][i];
            if (--buttom < top) break;

            for (int i = buttom; i >= top; i --) result[x++] = matrix[i][left];
            if (++left > right) break;
        }
        return result;
    }
}
