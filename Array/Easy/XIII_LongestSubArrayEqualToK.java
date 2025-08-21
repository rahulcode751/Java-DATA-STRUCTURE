package Easy;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
public class XIII_LongestSubArrayEqualToK
{
    public int longestSubarray(int[] arr, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, preSum = 0;

        for(int i=0; i<arr.length; i++){
            preSum += arr[i];

            if(preSum == k){
                res = i+1;
            }else if(map.containsKey(preSum-k) == true){
                res = Math.max(res, i - map.get(preSum - k));
            }

            if(!map.containsKey(preSum)){
                map.put(preSum,i);
            }
        }
        return res;
    }
}
