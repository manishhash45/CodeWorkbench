package com.mk.java.dp;

import java.util.Arrays;

public class LongestCommonSubsequenceMemo {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println("Length of LCS is " + lcsMemo(m - 1, n - 1, s1, s2, dp));
    }



    //Memoization
    static int lcsMemo(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsMemo(i - 1, j - 1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(
                lcsMemo(i - 1, j, s1, s2, dp),
                lcsMemo(i, j - 1, s1, s2, dp)
        );
    }
}
