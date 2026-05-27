package com.mk.java.dp.subsequence;

public class CoinChangeProblem {

//    You are given an integer array coins representing coins of different denominations and an integer amount
//    representing a total amount of money.
//    Return the fewest number of coins that you need to make up that amount.
//    If that amount of money cannot be made up by any combination of the coins, return -1.
//    You may assume that you have an infinite number of each kind of coin.


    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amount = 27;
        System.out.println("Minimum number of coins required: " + coinChangeRecursive(coins, amount, coins.length - 1));
    }

    private static int coinChangeRecursive(int[] coins, int amount, int index) {
        if (index == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return Integer.MAX_VALUE;
        }
        int excludeCoin = coinChangeRecursive(coins, amount, index-1);
        int includeCoin = Integer.MAX_VALUE;

        if (coins[index] <= amount) {
            int res = coinChangeRecursive(coins, amount - coins[index], index);
            if (res != Integer.MAX_VALUE) {  // ✅ prevent overflow
                includeCoin = 1 + res;
            }
        }

        return Math.min(includeCoin, excludeCoin);
    }





}
