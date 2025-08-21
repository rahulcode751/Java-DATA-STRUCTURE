package DPonStrings;

// https://leetcode.com/problems/shortest-common-supersequence/
public class V_LongestCommongSubsequence
{
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = longestCommonSubsequence(str1,str2);
        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();
        for (char c : lcs.toCharArray()) {
            while (i < str1.length() && str1.charAt(i) != c) {
                result.append(str1.charAt(i++));
            }
            while (j < str2.length() && str2.charAt(j) != c) {
                result.append(str2.charAt(j++));
            }
            result.append(c);
            i++;
            j++;
        }
        while (i < str1.length()) {
            result.append(str1.charAt(i++));
        }
        while (j < str2.length()) {
            result.append(str2.charAt(j++));
        }
        return result.toString();
    }
    public String longestCommonSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=m; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcs.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }
}
