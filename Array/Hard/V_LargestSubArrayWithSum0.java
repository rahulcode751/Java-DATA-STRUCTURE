package Hard;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?category%5B%5D=Hash&company%5B%5D=Amazon&page=1&query=category%5B%5DHashcompany%5B%5DAmazonpage1company%5B%5DAmazoncategory%5B%5DHash&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum
public class V_LargestSubArrayWithSum0
{
    int maxLen(int arr[]) {
        Map<Integer,Integer> mp = new HashMap<>();
        int sum = 0,ans = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum == 0) ans = i+1;
            if(mp.containsKey(sum) == true){
                ans = Math.max(ans,i-mp.get(sum)+1);
            }else mp.put(sum,i+1);

        }
        return ans;
    }
}
