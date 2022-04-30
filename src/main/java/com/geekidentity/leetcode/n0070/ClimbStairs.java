package com.geekidentity.leetcode.n0070;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 计算机只会运行判断和简单重复性问题，因此要找最近重复子问题
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2, c = 3;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
