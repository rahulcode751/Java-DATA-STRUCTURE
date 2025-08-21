package DPonSubsequences.Part2;

// https://leetcode.com/problems/coin-change/description/
public class I_CoinChange
{
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        int INF = (int) 1e9;
        int[][] dp = new int[n][amt + 1];
        for (int j = 0; j <= amt; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = j / coins[0];
            else
                dp[0][j] = INF;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amt; j++) {
                int notTake = dp[i - 1][j];
                int take = INF;
                if (coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(notTake, take);
            }
        }

        return dp[n - 1][amt] >= INF ? -1 : dp[n - 1][amt];
    }
}
