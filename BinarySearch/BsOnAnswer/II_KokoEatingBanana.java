package BsOnAnswer;

import java.util.Arrays;

// https://leetcode.com/problems/koko-eating-bananas/
public class II_KokoEatingBanana
{
    long check(int[] piles,int h,int mid){
        long count = 0;
        for(int i=0; i<piles.length; i++){
            count = count + piles[i]/mid + ((piles[i]%mid == 0) ? 0 : 1);
        }
        return count;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1,high = Arrays.stream(piles).max().getAsInt();
        int ans1 = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            long ans = check(piles,h,mid);
            if(ans <= h){
                ans1 = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans1;
    }
}
