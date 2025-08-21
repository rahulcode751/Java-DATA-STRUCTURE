package DPonSubsequences.Part3;

// https://www.geeksforgeeks.org/problems/rod-cutting0840/1
public class I_RodCutting
{
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];

        for(int i=0; i<=n; i++){
            dp[0][i] = i*price[0];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=n; j++){
                int nottake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(i+1 <= j){
                    take = price[i] + dp[i][j-i-1];
                }
                dp[i][j] = Math.max(nottake,take);
            }
        }
        return dp[n-1][n];

    }
}
