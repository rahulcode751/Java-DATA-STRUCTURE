package ShortestPath;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
public class XI_ProblemOnFloydWarshal
{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
        }
        for(int[] it: edges){
            matrix[it[0]][it[1]] = it[2];
            matrix[it[1]][it[0]] = it[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                            matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int cityCount = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = n-1; i >= 0; --i) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] <= distanceThreshold && i!=j){
                    cnt++;
                }
            }
            if(cnt < cityCount){
                cityCount = cnt;
                ans = i;
            }
        }
        return ans;
    }
}
