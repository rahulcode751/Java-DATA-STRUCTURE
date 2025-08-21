package Easy;

// https://leetcode.com/problems/max-consecutive-ones/description/
public class XI_MaxConsecutiveOne
{
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0,max = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) {
                max = Math.max(ans, max);
                ans = 0;
            }
            else ans++;
        }
        return Math.max(ans, max);
    }
}
