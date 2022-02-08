package com.geekidentity.leetcode.offerII;

/**
 * 动态规划
 * 面试题19. 正则表达式匹配
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 *
 * 剑指Offer上无法复现
 */
public class Offer19IsMatch {
    private char[] str, pattern;

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        str = s.toCharArray();
        pattern = p.toCharArray();
        return matchCore(0, 0);
    }

    private boolean matchCore(int i, int j) {
        if (str[i] == '\0' && pattern[j] == '\0') return true;
        if (str[i] != '\0' && pattern[j] != '\0') return false;
        if (pattern[j + 1] == '*') {
            if (pattern[j] == str[i] || (pattern[j] == '.' && str[i] != '\0')) {
                // move on the next state
                return matchCore(i + 1, j + 2)
                        // stay on the current state
                        || matchCore(i + 1, j)
                        // ignore a '*'
                        || matchCore(i, j + 2);
            } else {
                // ignore a '*'
                return matchCore(i, j + 2);
            }
        }
        if (str[i] == pattern[j] || (pattern[j] == '.' && str[i] != '\0'))
            return matchCore(i + 1, j + 1);
        return false;
    }
}
