package DPonStrings;

// https://leetcode.com/problems/wildcard-matching/description/
public class VII_WildcardMatching
{
    public boolean isMatch(String s, String p) {
        return solve(s,p);
    }
    public boolean solve(String S1, String S2) {
        int m = S1.length();
        int n = S2.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = false;
        }
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if(S2.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(S2.charAt(j-1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(S2.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}
