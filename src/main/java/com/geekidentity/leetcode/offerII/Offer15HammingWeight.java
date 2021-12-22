package com.geekidentity.leetcode.offerII;

/**
 * 位运算
 * 剑指 Offer 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * Java中 >> 表示有符号右移，>>> 为无符号右移
 */
public class Offer15HammingWeight {
    public int hammingWeight1(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
