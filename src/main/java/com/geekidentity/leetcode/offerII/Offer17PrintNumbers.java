package com.geekidentity.leetcode.offerII;

/**
 * 分治算法
 * 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 这个实际上是大数问题，可以采用字符串加法，这里针对加法做了优化
 */
public class Offer17PrintNumbers {
    public int[] printNumbers(int n) {
        int count = (int) Math.pow(10, n) - 1;
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
