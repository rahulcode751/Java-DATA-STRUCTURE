package ProblemsOnBfsAndDfs;

import java.util.*;

// https://leetcode.com/problems/01-matrix/description/
public class V_01Matrix
{
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    bfs(i,j,dist,mat);
                }
            }
        }
        return dist;
    }

    public void bfs(int r,int c, int[][] dist, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(r,c));
        dist[r][c] = 0;

        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.poll();
            int row = pair.getKey();
            int col = pair.getValue();

            int[] delRow = {1,-1,0,0};
            int[] delCol = {0,0,-1,1};

            for(int i=0; i<4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] == 1 && dist[nrow][ncol] > dist[row][col] + 1){
                    dist[nrow][ncol] = dist[row][col] + 1;
                    q.offer(new Pair<>(nrow,ncol));
                }
            }
        }
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
