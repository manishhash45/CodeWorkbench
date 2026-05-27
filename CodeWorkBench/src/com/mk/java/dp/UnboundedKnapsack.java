package com.mk.java.dp;

import java.util.Arrays;
import java.util.Scanner;

public class UnboundedKnapsack {
    // 1️⃣ Recursive Approach
    static int recursive(int i, int W, int[] wt, int[] val) {
        if (i == 0) {
            return (W / wt[0]) * val[0];
        }

        int notTake = recursive(i - 1, W, wt, val);

        int take = Integer.MIN_VALUE;
        if (wt[i] <= W) {
            take = val[i] + recursive(i, W - wt[i], wt, val);
        }

        return Math.max(take, notTake);
    }

    // 2️⃣ Memoization
    static int memo(int i, int W, int[] wt, int[] val, int[][] dp) {
        if (i == 0) {
            return (W / wt[0]) * val[0];
        }

        if (dp[i][W] != -1) return dp[i][W];

        int notTake = memo(i - 1, W, wt, val, dp);

        int take = Integer.MIN_VALUE;
        if (wt[i] <= W) {
            take = val[i] + memo(i, W - wt[i], wt, val, dp);
        }

        return dp[i][W] = Math.max(take, notTake);
    }

    // 3️⃣ Tabulation
    static int tabulation(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n][W + 1];

        // Base case
        for (int w = 0; w <= W; w++) {
            dp[0][w] = (w / wt[0]) * val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {

                int notTake = dp[i - 1][w];

                int take = Integer.MIN_VALUE;
                if (wt[i] <= w) {
                    take = val[i] + dp[i][w - wt[i]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];
    }

    // 4️⃣ Space Optimization (1D DP)
    static int spaceOptimized(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[] dp = new int[W + 1];

        // Base case
        for (int w = 0; w <= W; w++) {
            dp[w] = (w / wt[0]) * val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int notTake = dp[w];

                int take = Integer.MIN_VALUE;
                if (wt[i] <= w) {
                    take = val[i] + dp[w - wt[i]];
                }

                dp[w] = Math.max(take, notTake);
            }
        }

        return dp[W];
    }

    // 🔹 Main Method with Switch Case
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int val[] = {5, 11, 13};
        int wt[] = {2, 4, 6};
        int n =wt.length;
        int W = 10;

        // Choice input
        int choice = sc.nextInt();

        int result = 0;

        switch (choice) {
            case 1:
                result = recursive(n - 1, W, wt, val);
                break;

            case 2:
                int[][] dp = new int[n][W + 1];
                for (int[] row : dp) Arrays.fill(row, -1);
                result = memo(n - 1, W, wt, val, dp);
                break;

            case 3:
                result = tabulation(wt, val, W);
                break;

            case 4:
                result = spaceOptimized(wt, val, W);
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println(result);
    }
}
