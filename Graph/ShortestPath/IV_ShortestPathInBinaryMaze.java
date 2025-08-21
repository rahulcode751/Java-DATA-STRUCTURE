package ShortestPath;

import java.util.*;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class IV_ShortestPathInBinaryMaze
{
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        pq.offer(new Pair<>(1,new Pair<>(0,0)));
        dist[0][0] = 1;

        while(!pq.isEmpty()){
            Pair<Integer,Pair<Integer,Integer>> p = pq.poll();
            int distance = p.getKey();
            int r = p.getValue().getKey();
            int c = p.getValue().getValue();

            if(r == n-1 && c == m-1) return distance;

            if(dist[r][c] < distance) continue;

            for(int i=-1; i<=1; i++){
                for(int j=-1; j<=1; j++){
                    int nrow = r+i;
                    int ncol = c+j;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && dist[nrow][ncol] > dist[r][c] + 1){
                        dist[nrow][ncol] = dist[r][c] + 1;
                        pq.offer(new Pair<>(dist[nrow][ncol], new Pair<>(nrow,ncol)));
                    }
                }
            }
        }

        return -1;
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

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}
