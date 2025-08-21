package Top20;

public class IV_EditDistance
{
    static int editDistRec(String s1, String s2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistRec(s1, s2, m - 1, n - 1);

        return 1 + Math.min(
                Math.min(editDistRec(s1, s2, m, n - 1),
                        editDistRec(s1, s2, m - 1, n)),
                editDistRec(s1, s2, m - 1, n - 1));
    }

    public int minDistance(String S1, String S2) {
        int m = S1.length();
        int n = S2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],Math.min(dp[i][j - 1],dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
