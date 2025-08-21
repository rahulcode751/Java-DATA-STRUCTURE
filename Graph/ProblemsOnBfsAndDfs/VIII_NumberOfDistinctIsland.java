package ProblemsOnBfsAndDfs;

import java.util.*;

// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
public class VIII_NumberOfDistinctIsland
{
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<ArrayList<Pair<Integer,Integer>>> st = new HashSet<>();
        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    vis[i][j] = true;
                    bfs(i,j,grid,vis,st);
                }
            }
        }

        return st.size();
    }
    public void bfs(int r, int c,int[][] grid, boolean[][] vis, Set<ArrayList<Pair<Integer,Integer>>> st){
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<Pair<Integer,Integer>> arr = new ArrayList<>();

        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(r,c));

        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.poll();
            int row = pair.getKey();
            int col = pair.getValue();

            arr.add(new Pair<>(row-r,col-c));

            int[] delRow = {1,-1,0,0};
            int[] delCol = {0,0,1,-1};

            for(int i=0; i<4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == false){
                    vis[nrow][ncol] = true;
                    q.offer(new Pair<>(nrow,ncol));
                }
            }
        }

        st.add(arr);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
            return value != null ? value.equals(pair.value) : pair.value == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
