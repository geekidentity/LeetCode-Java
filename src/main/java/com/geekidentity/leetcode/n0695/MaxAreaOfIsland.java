package com.geekidentity.leetcode.n0695;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int area = area(grid, row, col);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int area(int[][] grid, int row, int col) {
        if (!inArea(grid, row, col)) return 0;
        if (grid[row][col] != 1) return 0;
        grid[row][col] = 2;
        return 1 +
                area(grid, row - 1, col) +
                area(grid, row + 1, col) +
                area(grid, row, col - 1) +
                area(grid, row, col + 1);
    }

    public boolean inArea(int[][] grid, int row, int col) {
        return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length;
    }
}
