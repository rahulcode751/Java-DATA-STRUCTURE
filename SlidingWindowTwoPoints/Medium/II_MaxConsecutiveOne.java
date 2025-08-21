package Medium;

import java.util.*;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class II_MaxConsecutiveOne
{
    public int longestOnes(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int l = 0,cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int r=0; r<nums.length; r++){
            if(nums[r] == 0){
                if(cnt < k){
                    cnt++;
                    q.offer(r);
                }else if(cnt == k && q.size() > 0){
                    l = q.poll()+1;
                    q.offer(r);
                }else{
                    l = r+1;
                }
            }
            ans = Math.max(ans,r-l+1);
        }
        if(ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}
