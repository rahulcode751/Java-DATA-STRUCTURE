package DPonGrid;

// https://leetcode.com/problems/minimum-falling-path-sum/description/
public class VI_MinFallingPathSum
{
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<n; i++){
            dp[m-1][i] = matrix[m-1][i];
        }

        for(int i=m-2; i>=0; --i){
            for(int j=0; j<n; j++){
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if (j - 1 >= 0) a = dp[i + 1][j - 1];
                if (j + 1 < n) b = dp[i + 1][j + 1];
                dp[i][j] = matrix[i][j] + Math.min(a,Math.min(dp[i+1][j],b));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(ans,dp[0][i]);
        }
        return ans;
    }
}
