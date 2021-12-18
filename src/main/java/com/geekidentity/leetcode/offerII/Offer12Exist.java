package com.geekidentity.leetcode.offerII;

/**
 * 搜索与回溯算法
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Offer12Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (hasPath(board, word.toCharArray(), visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] board, char[] word, boolean[][] visited, int i, int j, int k) {
        int row = board.length, col = board[0].length;
        if (k == word.length) {
            return true;
        }
        boolean hasPath = false;
        if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j] && word[k] == board[i][j]) {
            k++;
            visited[i][j] = true;
            hasPath = hasPath(board, word, visited, i + 1, j, k) ||
                    hasPath(board, word, visited, i - 1, j, k) ||
                    hasPath(board, word, visited, i, j + 1, k) ||
                    hasPath(board, word, visited, i, j - 1, k);
            if (!hasPath) {
                --k;
                visited[i][j] = false;
            }
        }
        return hasPath;
    }
}
