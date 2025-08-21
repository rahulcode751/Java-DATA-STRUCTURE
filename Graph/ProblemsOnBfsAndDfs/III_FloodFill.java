package ProblemsOnBfsAndDfs;

// https://leetcode.com/problems/flood-fill/
public class III_FloodFill
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        dfs(image,ans,sr,sc,color,image[sr][sc]);
        return image;
    }
    public void dfs(int[][] grid,int[][] ans, int u, int v,int color, int mainCol){
        int n = grid.length;
        int m = grid[0].length;

        grid[u][v] = color;

        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int row = u + drow[i];
            int col = v + dcol[i];

            if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == mainCol && ans[row][col] != color) {
                dfs(grid,ans, row, col, color, mainCol);
            }
        }
    }
}
