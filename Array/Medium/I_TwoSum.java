package Medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
public class I_TwoSum
{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(target-nums[i]) == true){
                return new int[] {mp.get(target-nums[i]),i};
            }
            mp.put(nums[i],i);
        }
        return new int[] {};
    }
}
