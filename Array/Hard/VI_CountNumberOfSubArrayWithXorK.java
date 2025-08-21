package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://www.interviewbit.com/problems/subarray-with-given-xor/
public class VI_CountNumberOfSubArrayWithXorK
{
    public int solve(ArrayList<Integer> nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int ans = 0,sum = 0;
        for(int i=0; i<nums.size(); i++){
            sum^=nums.get(i);
            if(mp.containsKey(sum^k) == true){
                ans += mp.get(sum^k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
