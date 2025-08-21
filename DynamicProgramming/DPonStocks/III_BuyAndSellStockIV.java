package DPonStocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
public class III_BuyAndSellStockIV
{
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i=0; i<=n; i++){
            dp[i][0][k] = dp[i][1][k] = 0;
        }
        for(int i=0; i<k; i++){
            dp[n][0][i] = dp[n][1][i] = 0;
        }
        for(int i=n-1; i>=0; --i){
            for(int buy = 0; buy<=1; buy++){
                for(int task=k-1; task>=0; --task){
                    if(buy==1){
                        dp[i][buy][task] = Math.max(-prices[i] + dp[i+1][0][task], 0 + dp[i+1][buy][task]);
                    }else{
                        dp[i][buy][task] = Math.max(prices[i] + dp[i+1][1][task+1], 0 + dp[i+1][buy][task]);
                    }
                }
            }
        }
        return dp[0][1][0];
    }
}
