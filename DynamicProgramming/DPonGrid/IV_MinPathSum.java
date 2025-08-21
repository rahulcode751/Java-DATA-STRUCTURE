package DPonGrid;

// https://leetcode.com/problems/minimum-path-sum/
public class IV_MinPathSum
{
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j== 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if(i-1 >= 0){
                    a = dp[i-1][j];
                }
                if(j-1 >= 0){
                    b = dp[i][j-1];
                }
                dp[i][j] = grid[i][j] + Math.min(a,b);
            }
        }
        return dp[m-1][n-1];
    }
}
