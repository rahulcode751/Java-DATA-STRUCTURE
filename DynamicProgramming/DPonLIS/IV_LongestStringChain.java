package DPonLIS;

import java.util.Arrays;

// https://leetcode.com/problems/longest-string-chain/description/
public class IV_LongestStringChain
{
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(words[i].length() == words[j].length() + 1){
                    int l = 0,flag = 0;
                    for(int k=0; k<words[i].length(); k++){
                        if(l < words[j].length() && words[i].charAt(k) == words[j].charAt(l)) l++;
                        else flag++;
                    }
                    if(l < words[j].length()) flag++;
                    if(flag == 1)dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans= Math.max(ans,dp[i]);
        }
        return ans;
    }
}
