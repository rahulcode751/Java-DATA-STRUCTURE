package DPonSquares;

import java.util.*;

// https://leetcode.com/problems/maximal-square/description/
public class II_MaximalSquare
{
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] hash = new int[m];
        int mx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] != '0'){
                    hash[j]+=1;
                }else hash[j] = 0;
            }
            mx = Math.max(mx,largestSquareArea(hash));
        }
        return mx;
    }
    public int largestSquareArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int mx = 0;
        int i = 0;
        while(i < n){
            if(st.size() == 0 || heights[st.peek()] <= heights[i]){
                st.push(i);
                i++;
            }else{
                int ind = st.peek();
                st.pop();
                int mi = Math.min(heights[ind],((st.size() == 0)? i: i-st.peek()-1));
                mx = Math.max(mx,mi*mi);
            }
        }
        while(st.size() != 0){
            int ind = st.peek();
            st.pop();
            int mi = Math.min(heights[ind],((st.size() == 0)? i: i-st.peek()-1));
            mx = Math.max(mx,mi*mi);
        }
        return mx;
    }
}
