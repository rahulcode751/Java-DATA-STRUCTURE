package Medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/description/
public class XIII_SpriralMatrix
{
    public List<Integer> spiralOrder(int[][] mat) {
        int rs = 0,re = mat.length-1, cs= 0, ce = mat[0].length-1, cnt = (re+1)*(ce+1);
        List<Integer> ans = new ArrayList<>();
        while(cnt > 0){
            for(int i=cs; i<=ce && cnt > 0; i++){
                ans.add(mat[rs][i]);
                cnt--;
            }
            rs++;
            for(int i=rs; i<=re && cnt > 0; i++){
                ans.add(mat[i][ce]);
                cnt--;
            }
            ce--;
            for(int i=ce; i>=cs && cnt > 0; --i){
                ans.add(mat[re][i]);
                cnt--;
            }
            re--;
            for(int i=re; i>=rs && cnt > 0; --i){
                ans.add(mat[i][cs]);
                cnt--;
            }
            cs++;
        }
        return ans;
    }
}
