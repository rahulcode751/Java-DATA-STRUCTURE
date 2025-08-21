package Top20;

public class VIII_OptimalStrategyForGame
{
    static int maxAmount(int i, int j, int[] arr) {
        if (i > j) return 0;

        int takeFirst = arr[i] + Math.min(maxAmount(i + 2, j, arr), maxAmount(i + 1, j - 1, arr));

        int takeLast = arr[j] + Math.min(maxAmount(i + 1, j - 1, arr), maxAmount(i, j - 2, arr));

        return Math.max(takeFirst, takeLast);
    }

    static int maximumAmount(int arr[]) {

        int n = arr.length;
        int dp[][] = new int[n][n];
        int gap, i, j, x, y, z;

        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {
                x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }
}
