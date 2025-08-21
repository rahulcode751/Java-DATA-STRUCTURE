package DPonStocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class IV_BuyAndSellStockCountdown
{
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;
        for(int i=n-1; i>=0; --i){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    dp[i][1] = Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
                }else{
                    int p = 0;
                    if(i+2 <= n){
                        p = dp[i+2][1];
                    }
                    dp[i][0] = Math.max(prices[i] + p,0 + dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }
}
