package com.geekidentity.leetcode.offerII;

/**
 * 分治算法
 * 剑指 Offer 16. 数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Offer16MyPow {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double result = 1;
        if (b < 0) {
            b = -b;
            x = 1/x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            //  x = x^2
            x *= x;
            b >>= 1;
        }
        return result;
    }
}
