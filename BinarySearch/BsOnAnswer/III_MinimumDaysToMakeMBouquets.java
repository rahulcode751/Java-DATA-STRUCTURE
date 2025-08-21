package BsOnAnswer;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class III_MinimumDaysToMakeMBouquets
{
    int check(int[] bloomDay,int mid,int k){
        int count = 0,sum = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= mid) count++;
            else{
                sum += count/k;
                count = 0;
            }
        }
        sum += count/k;
        return sum;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1,high = Arrays.stream(bloomDay).max().getAsInt();
        long ans1 = Long.MAX_VALUE;
        if(m*k > bloomDay.length) return -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int ans = check(bloomDay,mid,k);
            if(ans < m){
                low = mid+1;
            }else{
                ans1 = mid;
                high = mid-1;
            }
        }
        return (int)ans1;
    }
}
