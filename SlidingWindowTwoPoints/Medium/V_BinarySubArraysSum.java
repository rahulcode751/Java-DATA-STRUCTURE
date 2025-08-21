package Medium;

import java.util.*;

// https://leetcode.com/problems/binary-subarrays-with-sum/description/
public class V_BinarySubArraysSum
{
    public int numSubarraysWithSum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,1);
        int sum = 0,cnt = 0;
        for(int r = 0; r<nums.length; r++){
            sum += nums[r];

            if(sum-k>=0 && m.containsKey(sum-k) == true){
                cnt += m.get(sum-k);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
