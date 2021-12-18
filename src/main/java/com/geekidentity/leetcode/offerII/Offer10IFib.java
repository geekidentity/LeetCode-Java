package com.geekidentity.leetcode.offerII;

/**
 * 动态规划
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Offer10IFib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int one = 0, two = 1, sum = one + two;
        for (int i = 1; i < n; i++) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }
}
