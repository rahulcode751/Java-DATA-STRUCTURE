package BsOnAnswer;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
public class IV_MinimumDivisor
{
    int check(int[] nums,int mid){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i]/mid + ((nums[i]%mid == 0)? 0:1);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1,high = Arrays.stream(nums).max().getAsInt();
        long ans1 = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            int ans = check(nums,mid);
            if(ans <= threshold){
                high = mid-1;
            }else{
                ans1 = mid;
                low = mid+1;
            }
        }
        return low;
    }
}
