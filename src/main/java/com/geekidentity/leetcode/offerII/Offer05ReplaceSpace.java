package com.geekidentity.leetcode.offerII;

/**
 * 字符串
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Offer05ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                count++;
            }
        }
        int newLength = s.length() + count * 2, k = 0;
        char[] newCharacter = new char[newLength];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                newCharacter[k++] = '%';
                newCharacter[k++] = '2';
                newCharacter[k++] = '0';
            } else {
                newCharacter[k++] = ch;
            }
        }
        return new String(newCharacter);
    }
}
