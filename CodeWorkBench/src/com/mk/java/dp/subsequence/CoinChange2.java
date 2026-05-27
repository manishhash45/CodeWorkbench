package com.mk.java.dp.subsequence;

public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println("Number of ways to get Amount : " + new CoinChange2().helper(coins.length - 1, amount, coins));
    }


    private int helper(int i, int amount, int[] coins) {
        // Base case
        if (i == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        int notTake = helper(i - 1, amount, coins);

        int take = 0;
        if (coins[i] <= amount) {
            take = helper(i, amount - coins[i], coins);
        }

        return take + notTake;
    }
//    Complexity
//    Time: Exponential (2^N)
//    Space: O(N) com.mk.java.recursion stack


    // Improved Solution

}
