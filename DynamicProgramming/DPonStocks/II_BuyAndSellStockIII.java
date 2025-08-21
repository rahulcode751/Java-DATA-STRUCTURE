package DPonStocks;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class II_BuyAndSellStockIII
{
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i=0; i<=n; i++){
            dp[i][0][2] = dp[i][1][2] = 0;
        }
        for(int i=0; i<3; i++){
            dp[n][0][i] = dp[n][1][i] = 0;
        }
        for(int i=n-1; i>=0; --i){
            for(int buy = 0; buy<=1; buy++){
                for(int task=1; task>=0; --task){
                    if(buy==1){
                        dp[i][1][task] = Math.max(-prices[i] + dp[i+1][0][task], 0 + dp[i+1][1][task]);
                    }else{
                        dp[i][0][task] = Math.max(prices[i] + dp[i+1][1][task+1], 0 + dp[i+1][0][task]);
                    }
                }
            }
        }
        return dp[0][1][0];
    }
}
