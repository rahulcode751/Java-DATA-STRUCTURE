package DPonLIS;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
public class V_LongestBitonicSubsequence
{
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp1[i] = Math.max(dp1[i],1+dp1[j]);
                }
            }
        }

        for(int i=n-2; i>=0; --i){
            for(int j=n-1; j>i; --j){
                if(nums[i] > nums[j]){
                    dp2[i] = Math.max(dp2[i],1+dp2[j]);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            if(dp1[i] > 1 && dp2[i] > 1){
                ans = Math.max(ans, dp1[i] + dp2[i] - 1);
            }
        }
        return ans;
    }
}
