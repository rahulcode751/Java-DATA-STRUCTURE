package DPonSubsequences.Part2;

// https://leetcode.com/problems/coin-change-ii/
public class II_CoinChangeII
{
    public int change(int amt, int[] coins) {
        return coinChange(coins,amt);
    }
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        int INF = 0;
        int[][] dp = new int[n][amt + 1];
        for (int j = 0; j <= amt; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amt; j++) {
                int notTake = dp[i - 1][j];
                int take = INF;
                if (coins[i] <= j) {
                    take = dp[i][j - coins[i]];
                }
                dp[i][j] = notTake + take;
            }
        }
        return dp[n-1][amt];
    }
}
