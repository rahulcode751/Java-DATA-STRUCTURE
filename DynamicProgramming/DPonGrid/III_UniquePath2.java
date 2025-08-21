package DPonGrid;

// https://leetcode.com/problems/unique-paths-ii/
public class III_UniquePath2
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j== 0) {
                    dp[i][j] = 1;
                    continue;
                }else if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                int a = 0, b = 0;
                if(i-1 >= 0){
                    a = dp[i-1][j];
                }
                if(j-1 >= 0){
                    b = dp[i][j-1];
                }
                dp[i][j] = a+b;
            }
        }
        return dp[m-1][n-1];
    }
}
