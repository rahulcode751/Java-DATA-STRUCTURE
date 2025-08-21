package DPonSubsequences;

// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class III_CountSubsetWIthSumK
{
    public int perfectSum(int[] arr, int sum) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][sum+1];

        for(int i=0; i<n; i++) dp[i][0] = 1;
        if(arr[0] <= sum) dp[0][arr[0]] = 1;

        for(int i=1; i<n; i++){
            for(int j=1; j<=sum; j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(arr[i] <= j){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = notTake + take;
            }
        }
        return dp[n-1][sum];
    }
}
