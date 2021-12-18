package com.geekidentity.leetcode.offerII;

/**
 * 动态规划
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class Offer63MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int d : prices) {
            if (d < min) {
                min = d;
            }
            int diff = d - min;
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }
}
