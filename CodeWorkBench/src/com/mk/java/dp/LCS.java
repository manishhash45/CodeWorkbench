package com.mk.java.dp;

import java.util.*;

public class LCS {

    static int rec(int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j))
            return 1 + rec(i - 1, j - 1, s1, s2);

        return Math.max(rec(i - 1, j, s1, s2), rec(i, j - 1, s1, s2));
    }

    static int recPrint(int i, int j, String s1, String s2 ,StringBuilder sb) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            sb.append(s1.charAt(i));
            return 1 + recPrint(i - 1, j - 1, s1, s2, sb);
        }

        StringBuilder sb1= new StringBuilder();
        StringBuilder sb2= new StringBuilder();

        int left = recPrint(i - 1, j, s1, s2, sb1);
        int right = recPrint(i, j - 1, s1, s2, sb2);

        if (left >= right) {
            sb.append(sb1); // keep the winner
            return left;
        } else {
            sb.append(sb2);
            return right;
        }
    }

    static String recPrint1(int i, int j, String s1, String s2 ) {
        if (i < 0 || j < 0) return " ";

        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + recPrint1(i - 1, j - 1, s1, s2);
        }

        String left = recPrint1(i - 1, j, s1, s2);
        String right = recPrint1(i, j - 1, s1, s2);

        return left.length()> right.length() ? left : right;
    }

    static int memo(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + memo(i - 1, j - 1, s1, s2, dp);

        return dp[i][j] = Math.max(
                memo(i - 1, j, s1, s2, dp),
                memo(i, j - 1, s1, s2, dp)
        );
    }

    static int tab(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    static int spaceOpt(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = "abcde";
        String s2 = "ace";

        int choice = sc.nextInt();

        int result = 0;

        switch (choice) {
            case 1:
                //result = rec(s1.length() - 1, s2.length() - 1, s1, s2);
                result=rec(s1.length() - 1, s2.length() - 1, s1, s2);
                StringBuilder sb = new StringBuilder();
                String result1= recPrint1(s1.length() - 1, s2.length() - 1, s1, s2);
                System.out.println("LCS: " + result1);
                break;

            case 2:
                int[][] dp = new int[s1.length()][s2.length()];
                for (int[] row : dp) Arrays.fill(row, -1);
                result = memo(s1.length() - 1, s2.length() - 1, s1, s2, dp);
                break;

            case 3:
                result = tab(s1, s2);
                break;

            case 4:
                result = spaceOpt(s1, s2);
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println(result);
    }
}