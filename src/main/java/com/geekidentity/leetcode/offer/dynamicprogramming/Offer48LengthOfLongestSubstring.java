package com.geekidentity.leetcode.offer.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class Offer48LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0, curLength = 0;
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer index = map.get(ch);
            if (index == null) {
                curLength++;
            } else {
                int len = i - index;
                if (len > curLength) {
                    curLength++;
                } else {
                    curLength = len;
                }
            }
            map.put(ch, i);
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        return maxLength;
    }
}
