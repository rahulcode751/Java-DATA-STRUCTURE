package Medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class XIV_CountSubaarayWithGivenSum
{
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int ans = 0,sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(mp.containsKey(sum-k) == true){
                ans += mp.get(sum-k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
