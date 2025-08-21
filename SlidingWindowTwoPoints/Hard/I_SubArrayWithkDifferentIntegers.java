package Hard;

import java.util.*;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class I_SubArrayWithkDifferentIntegers
{
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums,k)-count(nums,k-1);
    }
    public static int count(int[] nums, int k){
        Map<Integer, Integer> m = new HashMap<>();
        int n = nums.length, i=0, j=0, cnt = 0;

        while(j < n){
            m.put(nums[j], m.getOrDefault(nums[j],0)+1);
            while(i <= j && m.size() > k){
                int freq = m.get(nums[i]);
                if(freq == 1) m.remove(nums[i]);
                else m.put(nums[i],freq-1);
                i++;
            }
            cnt += (j-i+1);
            j++;
        }
        return cnt;
    }
}
