package com.geekidentity.leetcode.offerII;

/**
 * 动态规划
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Offer10IINumWays {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int one = 0, two = 1, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }
}
