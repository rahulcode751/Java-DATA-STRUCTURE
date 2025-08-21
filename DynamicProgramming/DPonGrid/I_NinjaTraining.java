package DPonGrid;

// https://www.geeksforgeeks.org/problems/geeks-training/1
public class I_NinjaTraining
{
    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int[][] dp = new int[n][3];

        for(int i=0; i<3; i++){
            dp[0][i] = arr[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = 0;
                for(int k=0; k<3; k++){
                    if(j != k){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][k] + arr[i][j]);
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0; i<3; i++){
            ans = Math.max(ans,dp[n-1][i]);
        }
        return ans;
    }
}
