package DPonSubsequences.Part2;

// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class III_01Knapsack
{
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];

        for(int i=0; i<=W; i++){
            if(wt[0] <= i){
                dp[0][i] = val[0];
            }
        }


        for(int i=1; i<n; i++){
            for(int j=0; j<=W; j++){
                int nottake = 0 + dp[i-1][j];
                int take = 0;
                if(wt[i] <= j){
                    take = val[i] + dp[i-1][j-wt[i]];
                }
                dp[i][j] = Math.max(nottake,take);
            }
        }
        return dp[n-1][W];
    }
}
