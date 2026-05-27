package com.mk.java.dp.subsequence;

import java.util.Arrays;

public class CoinChange2Memo {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Number of coins required: " + new CoinChange2Memo().change(amount, coins));

    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(n - 1, amount, coins, dp);
    }

    private int helper(int i, int amount, int[] coins, int[][] dp) {
        if (i == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        if (dp[i][amount] != -1) return dp[i][amount];

        int notTake = helper(i - 1, amount, coins, dp);

        int take = 0;
        if (coins[i] <= amount) {
            take = helper(i, amount - coins[i], coins, dp);
        }

        return dp[i][amount] = take + notTake;
    }
//    Complexity
//    Time: O(N × amount)
//    Space: O(N × amount) + com.mk.java.recursion stack


    //Tabulation (Bottom-Up DP)
    public int changeWithTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Base case
        for (int a = 0; a <= amount; a++) {
            if (a % coins[0] == 0) dp[0][a] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int a = 0; a <= amount; a++) {

                int notTake = dp[i - 1][a];

                int take = 0;
                if (coins[i] <= a) {
                    take = dp[i][a - coins[i]];
                }

                dp[i][a] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }

    //    4️⃣ Space Optimization (Most Important)
    public int changeSpaceOptimization(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1; // Base case

        for (int coin : coins) {
            for (int a = coin; a <= amount; a++) {
                dp[a] += dp[a - coin];
            }
        }

        return dp[amount];
    }
}
