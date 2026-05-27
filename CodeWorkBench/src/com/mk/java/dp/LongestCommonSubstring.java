package com.mk.java.dp;

import java.util.*;

public class LongestCommonSubstring {

    // 1️⃣ Recursive Approach (returns length)
    static int rec(int i, int j, String s1, String s2, int count) {
        if (i < 0 || j < 0) return count;

        int res = count;

        if (s1.charAt(i) == s2.charAt(j)) {
            res = rec(i - 1, j - 1, s1, s2, count + 1);
        }

        int c1 = rec(i - 1, j, s1, s2, 0);
        int c2 = rec(i, j - 1, s1, s2, 0);

        return Math.max(res, Math.max(c1, c2));
    }

    // 2️⃣ Tabulation (length + substring)
    static String tabulation(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        int maxLen = 0;
        int endIndex = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        if (maxLen == 0) return "";
        return s1.substring(endIndex - maxLen + 1, endIndex + 1);
    }

    // 3️⃣ Space Optimized (length only)
    static int spaceOptimized(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[] prev = new int[m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];

            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    maxLen = Math.max(maxLen, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }

            prev = curr;
        }

        return maxLen;
    }

    // 🔹 Main with Switch Case
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = "abcde";
        String s2 = "abfce";

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                int res = rec(s1.length() - 1, s2.length() - 1, s1, s2, 0);
                System.out.println("Length: " + res);
                break;

            case 2:
                String substr = tabulation(s1, s2);
                System.out.println("Substring: " + substr);
                System.out.println("Length: " + substr.length());
                break;

            case 3:
                int len = spaceOptimized(s1, s2);
                System.out.println("Length: " + len);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}
