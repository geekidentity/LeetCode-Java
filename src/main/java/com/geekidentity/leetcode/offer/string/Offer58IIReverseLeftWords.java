package com.geekidentity.leetcode.offer.string;

/**
 * 字符串
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Offer58IIReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() < 1 || n <= 0 || n >= s.length()) {
            return s;
        }
        String first = s.substring(0, n);
        String second = s.substring(n, s.length());
        return second + first;
    }
}
