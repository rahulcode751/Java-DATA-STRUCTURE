package Medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class X_LongestConsecutiveSequenceInArray
{
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int elem: nums) st.add(elem);
        int ans = 0;
        for(int elem: st){
            int num = elem, len = 1;
            if(st.contains(elem-1) == false){
                while(st.contains(num+1) == true){
                    num++;
                    len++;
                }
            }
            ans = Math.max(ans,len);
        }
        return ans;
    }
}
