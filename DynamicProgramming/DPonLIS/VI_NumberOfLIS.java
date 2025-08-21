package DPonLIS;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class VI_NumberOfLIS
{
    public int findNumberOfLIS(int[] v) {
        int n= v.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxi = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(v[j] < v[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                }else if(v[j] < v[i] && dp[i] == dp[j]+1){
                    count[i] += count[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(maxi == dp[i]) cnt += count[i];
        }
        return cnt;
    }
}
