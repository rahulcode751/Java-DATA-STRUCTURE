package Medium;

// https://leetcode.com/problems/rotate-image/description/
public class XII_Rotatematrix
{
    class Solution {
        public void rotate(int[][] mat) {
            for(int i=0; i<mat.length; i++){
                for(int j=0; j<=i; j++){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
            for(int i=0; i<mat.length; i++){
                reverse(mat[i]);
            }
        }
        public void reverse(int[] mat){
            int low = 0,high = mat.length - 1;
            while(low < high){
                int temp = mat[low];
                mat[low] = mat[high];
                mat[high] = temp;
                low++;
                high--;
            }
        }
    }
}
