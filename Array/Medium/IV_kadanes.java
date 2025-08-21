package Medium;

// https://leetcode.com/problems/maximum-subarray/description/
public class IV_kadanes
{
    public int maxSubArray(int[] nums) {
        int sum = 0, mx = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum >= mx){
                mx = sum;
            }
            if(sum < 0) sum = 0;
        }
        return mx;
    }
}
