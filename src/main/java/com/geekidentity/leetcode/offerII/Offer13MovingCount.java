package com.geekidentity.leetcode.offerII;

/**
 * 搜索与回溯算法
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Offer13MovingCount {
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k == 0) {
            return 1;
        }
        if (k < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        return movingCount(m, n, 0, 0, k, visited);
    }

    private int movingCount(int m, int n, int row, int col, int k, boolean[][] visited) {
        int count = 0;
        if (check(m, n, row, col, k, visited)) {
            visited[row][col] = true;
            count = 1 + movingCount(m, n, row - 1, col, k, visited)
                    + movingCount(m, n, row + 1, col, k, visited)
                    + movingCount(m, n, row, col - 1, k, visited)
                    + movingCount(m, n, row, col + 1, k, visited);
        }
        return count;
    }

    private boolean check(int m, int n, int row, int col, int k, boolean[][] visited) {
        return row >= 0 && row < m && col >= 0 && col < n
                && digitSum(row) + digitSum(col) <= k && !visited[row][col];
    }

    private int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
