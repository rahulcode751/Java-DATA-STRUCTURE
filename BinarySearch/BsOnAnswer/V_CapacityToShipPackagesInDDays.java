package BsOnAnswer;

import java.util.Arrays;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class V_CapacityToShipPackagesInDDays
{
    public static boolean check(int[] weights,int days,long mid){
        long sum = 0,count = 0;
        for(int i=0; i<weights.length; i++){
            if(weights[i] > mid) return false;
            if(sum + weights[i] <= mid){
                sum += weights[i];
            }else{
                count++;
                sum = weights[i];
            }
        }
        if(sum != 0) count++;
        if(count <= days) return true;
        else return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        long low = 1,high = Arrays.stream(weights).sum();
        long ams = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            boolean ans = check(weights,days,mid);
            if(ans == true){
                ams = mid;
                high = mid-1;

            }else{
                low = mid+1;
            }
        }
        return (int) ams;
    }
}
