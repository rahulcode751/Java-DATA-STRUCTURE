package BsOnAnswer;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/aggressive-cows/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class VI_AggressiveCows
{
    public static boolean check(int[] stalls, int k, long mid){
        int count = 1,prev = stalls[0];
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-prev >=  mid){
                count++;
                prev = stalls[i];
            }
        }
        if(count >= k) return true;
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        long low = 1, high = stalls[stalls.length-1];
        int ans = (int)high;
        while(low <= high){
            long mid = low + (high-low)/2;
            boolean ch = check(stalls,k,mid);
            if(ch == true){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return (int)high;
    }
}
