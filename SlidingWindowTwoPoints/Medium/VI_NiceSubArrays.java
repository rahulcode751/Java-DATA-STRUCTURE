package Medium;

import java.util.*;

// https://leetcode.com/problems/count-number-of-nice-subarrays/
public class VI_NiceSubArrays
{
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0, cnt = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,1);
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r]%2;

            if(sum-k >= 0 && m.containsKey(sum-k)==true){
                cnt += m.get(sum-k);
            }

            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
