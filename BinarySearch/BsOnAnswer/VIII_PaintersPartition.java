package BsOnAnswer;

import java.util.ArrayList;
import java.util.Collections;

// https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
public class VIII_PaintersPartition
{
    public static boolean check(ArrayList<Integer> nums,int n,int k, int mid){
        int sum = 0,count = 1,flag = 0;
        for(int i=0; i<n; i++){
            if(nums.get(i) > mid) return false;
            if(sum + nums.get(i) <= mid){
                sum += nums.get(i);
            }else{
                count++;
                sum = nums.get(i);
            }
        }
        if(count > k) return true;
        return false;
    }
    public static int findLargestMinDistance(ArrayList<Integer> nums, int k)
    {
        int low = Collections.min(nums);
        int high = nums.stream().mapToInt(Integer::intValue).sum();
        int n = nums.size();
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
