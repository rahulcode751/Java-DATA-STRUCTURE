package ProblemsOnBfsAndDfs;

// https://leetcode.com/problems/surrounded-regions/
public class VI_SurroundingRegions
{
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && board[i][j] == 'O'){
                    dfs(i,j,board,vis);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O' && vis[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] board,boolean[][] vis){
        int n = board.length;
        int m = board[0].length;

        vis[r][c] = true;

        int[] delRow = {1,-1,0,0};
        int[] delCol = {0,0,-1,1};

        for(int i=0; i<4; i++){
            int row = r + delRow[i];
            int col = c + delCol[i];

            if(row >= 0 && row < n && col >= 0 && col < m && board[row][col] == 'O' && vis[row][col] == false){
                dfs(row,col,board,vis);
            }
        }
    }
}
