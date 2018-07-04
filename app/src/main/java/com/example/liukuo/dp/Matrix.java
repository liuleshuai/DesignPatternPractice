package com.example.liukuo.dp;

/**
 * 动态规划
 * 一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，
 * 从左上走到右下，只能向下向右走，求能够获得的最大价值。例如：3 * 3的方格。
 * <p>
 * 1 3 3
 * 2 1 3
 * 2 2 1
 * <p>
 * 能够获得的最大价值为：11。
 * Created by LiuKuo at 2018/7/4
 */

public class Matrix {
    private static int go(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int right = 0;
                int bottom = 0;
                if (j > 0) {
                    right = dp[i][j - 1] + matrix[i][j];
                }
                if (i > 0) {
                    bottom = dp[i - 1][j] + matrix[i][j];
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = Math.max(right, bottom);
                }
            }
        }
        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 3}, {2, 1, 3}, {2, 2, 1}};
        int gift = go(matrix);
        System.out.println(gift);
    }
}
