package DPonGrid;

// https://leetcode.com/problems/cherry-pickup-ii/
public class VII_CherryPickUpII
{
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        dp[0][0][m-1] = grid[0][0] + grid[0][m-1];

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<m; k++){
                    int mx = Integer.MIN_VALUE;
                    int val = 0;
                    if(j == k){
                        val = grid[i][j];
                    }else{
                        val = grid[i][j] + grid[i][k];
                    }
                    for(int l=-1; l<=1; l++){
                        for(int x=-1; x<=1; x++){
                            if(j+l >= 0 && j+l < m && k+x >=0 && k+x < m){
                                mx = Math.max(mx, dp[i-1][j+l][k+x]);
                            }
                        }
                    }
                    dp[i][j][k] = val + mx;
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                ans = Math.max(ans, dp[n - 1][j][k]);
            }
        }
        return ans;
    }
}
