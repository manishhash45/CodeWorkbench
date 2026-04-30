package dp.subsequence;

public class CoinChangeDPSolution {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum number of coins required: " + new CoinChangeDPSolution().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int i = coins.length;
        int j = amount + 1;
        int[][] dp = new int[i][j];

        for (int i1 = 0; i1 < i; i1++)
            for (int j1 = 0; j1 < j; j1++)
                dp[i1][j1] = -1;


        int ans = coinChangeRecursive(coins, amount, coins.length - 1, dp);

        if (ans >= Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }

    private int coinChangeRecursive(int[] coins, int amount, int index, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return Integer.MAX_VALUE;
        }

        if (dp[index][amount] != -1) return dp[index][amount];

        int excludeCoin = coinChangeRecursive(coins, amount, index - 1, dp);
        int includeCoin = Integer.MAX_VALUE;

        if (coins[index] <= amount) {
            int res = coinChangeRecursive(coins, amount - coins[index], index, dp);
            if (res != Integer.MAX_VALUE) { // ✅ prevent overflow
                includeCoin = 1 + res;
            }
        }
        return dp[index][amount] = Math.min(includeCoin, excludeCoin);
    }
}
