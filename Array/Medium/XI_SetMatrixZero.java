package Medium;

// https://leetcode.com/problems/set-matrix-zeroes/description/
public class XI_SetMatrixZero
{
    class Solution {
        public void setZeroes(int[][] mat) {
            boolean flag = false,flag2 = false,flag3 = false;
            for(int i=1; i<mat[0].length; i++){
                if(mat[0][i] == 0){
                    flag2 = true;
                    break;
                }
            }
            for(int j=1; j<mat.length; j++) {
                if(mat[j][0] == 0){
                    flag3 = true;
                    break;
                }
            }
            for(int i=0; i<mat.length; i++){
                for(int j=0; j<mat[0].length; j++){
                    if(mat[i][j] == 0){
                        if(i == 0 && j == 0) flag = true;
                        else{
                            mat[i][0] = 0;
                            mat[0][j] = 0;
                        }
                    }
                }
            }
            for(int i=1; i<mat.length; i++){
                for(int j=1; j<mat[0].length; j++){
                    if(i ==0 && j == 0) continue;
                    if(mat[i][0] == 0 || mat[0][j] == 0){
                        mat[i][j] = 0;
                    }
                }
            }
            if(flag == true){
                for(int j=0; j<mat[0].length; j++) mat[0][j] = 0;
                for(int i=0; i<mat.length; i++) mat[i][0] = 0;
            }
            if(flag2 == true){
                for(int j=0; j<mat[0].length; j++) mat[0][j] = 0;
            }
            if(flag3 == true){
                for(int j=0; j<mat.length; j++) mat[j][0] = 0;
            }
        }
    }
}
