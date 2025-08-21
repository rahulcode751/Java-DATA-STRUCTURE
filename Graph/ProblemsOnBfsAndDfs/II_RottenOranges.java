package ProblemsOnBfsAndDfs;

// https://leetcode.com/problems/rotting-oranges/
public class II_RottenOranges
{
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] time = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2 || grid[i][j] == 0){
                    time[i][j] = 0;
                }else if(grid[i][j] == 1){
                    time[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    dfs(grid,time,i,j);
                }
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans,time[i][j]);
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public void dfs(int[][] grid, int[][] time, int u, int v){
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};

        for(int i=0; i<4; i++){
            int row = u + drow[i];
            int col = v + dcol[i];

            if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && time[row][col] > time[u][v] + 1){
                time[row][col] = time[u][v] + 1;
                dfs(grid,time,row,col);
            }
        }
    }
}
