package com.geekidentity.leetcode.offer.doublepointer;

/**
 * 双指针
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class Offer58IReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] strArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArray.length - 1; i >=0; i--) {
            String str = strArray[i];
            if (!"".equals(str)) {
                sb.append(str).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
