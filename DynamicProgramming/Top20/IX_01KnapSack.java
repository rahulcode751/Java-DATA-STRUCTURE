package Top20;

public class IX_01KnapSack
{
    static int knapsackRec(int W, int[] val, int[] wt, int n) {
        if (n == 0 || W == 0) return 0;

        int pick = 0;
        if (wt[n - 1] <= W)
            pick = val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1);

        int notPick = knapsackRec(W, val, wt, n - 1);

        return Math.max(pick, notPick);
    }


    static int knapsack(int W, int[] val, int[] wt) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0 || j == 0)  dp[i][j] = 0;
                else {
                    int pick = 0;

                    if (wt[i - 1] <= j)
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];

                    // Don't pick the ith item
                    int notPick = dp[i - 1][j];

                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][W];
    }
}
