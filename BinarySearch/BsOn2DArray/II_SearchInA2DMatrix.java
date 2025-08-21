package BsOn2DArray;

// https://leetcode.com/problems/search-a-2d-matrix/
public class II_SearchInA2DMatrix
{
    public boolean searchMatrix(int[][] mat, int target) {
        int r = mat.length-1;
        int c = mat[0].length-1;
        int i=0,j=c;
        while(i <= r && i>=0 && j <= c && j >= 0){
            if(mat[i][j] == target) return true;
            else if(mat[i][j] < target) i++;
            else if(mat[i][j] > target) j--;
        }
        return false;
    }
}
