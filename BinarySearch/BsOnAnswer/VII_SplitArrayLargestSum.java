package BsOnAnswer;

import java.util.Arrays;

// https://leetcode.com/problems/split-array-largest-sum/
public class VII_SplitArrayLargestSum
{
    public static boolean check(int[] nums,int n,int k, int mid){
        int sum = 0,count = 1,flag = 0;
        for(int i=0; i<n; i++){
            if(nums[i] > mid) return false;
            if(sum + nums[i] <= mid){
                sum += nums[i];
            }else{
                count++;
                sum = nums[i];
            }
        }
        if(count > k) return true;
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int n = nums.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            boolean ans = check(nums,n,k,mid);
            if(ans == true){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
