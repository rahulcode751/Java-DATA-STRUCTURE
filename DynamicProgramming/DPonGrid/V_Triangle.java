package DPonGrid;

import java.util.*;

// https://leetcode.com/problems/triangle/description/
public class V_Triangle
{
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = m;
        int[][] dp = new int[m][n];
        for(int i=0; i<n; i++){
            dp[m-1][i] = triangle.get(m-1).get(i);
        }

        for(int i=m-2; i>=0; --i){
            for(int j = 0; j<triangle.get(i).size(); j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
