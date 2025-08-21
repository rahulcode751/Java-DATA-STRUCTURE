package DPonLIS;

import java.util.*;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class I_LIS
{
    // TC = n*n;
    public int lengthOfLIS(int[] v) {
        int n= v.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            int ans = 1;
            for(int j=0; j<i; j++){
                if(v[j] < v[i]){
                    ans = Math.max(ans,dp[j] + 1);
                }
            }
            dp[i] = ans;;
        }
        int ans = 1;
        for(int i=1; i<n; i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    // TC = nlogn
    public int lengthOfLISUsingBianrySearch(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            if (res.isEmpty() || res.get(res.size() - 1) < n) {
                res.add(n);
            } else {
                int idx = binarySearch(res, n);
                res.set(idx, n);
            }
        }
        return res.size();
    }
    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
