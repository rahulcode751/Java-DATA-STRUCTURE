package Hard;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/description/
public class I_PascalTriangle
{
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        int cnt = 0;
        while(cnt < numRows){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for(int i=0; i<prev.size()-1; i++){
                temp.add(prev.get(i) + prev.get(i+1));
            }
            if(cnt!=0) temp.add(1);
            ans.add(temp);
            prev = temp;
            cnt++;
        }
        return ans;
    }
}
