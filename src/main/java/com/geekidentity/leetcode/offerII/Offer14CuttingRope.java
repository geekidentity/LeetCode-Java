package com.geekidentity.leetcode.offerII;

/**
 * 数学
 * 剑指 Offer 14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class Offer14CuttingRope {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

    /**
     * 使用动态规划更好理解
     */
    public int dp(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] product = new int[n + 1];

        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            // i/2 是为了减少无用匹配
            for (int j = 1; j <= i / 2; j++) {
                int p = product[j] * product[i - j];
                if (max < p) max = p;
                product[i] = max;
            }
        }
        return product[n];
    }
}
