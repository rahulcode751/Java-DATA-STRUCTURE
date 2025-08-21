package Top20;

import java.util.*;

// https://www.geeksforgeeks.org/dsa/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
public class V_PartitionSubsetMinimum
{
    // Function to calculate the minimum absolute difference
    static int findMinDifference(ArrayList<Integer> arr, int n, int sumCalculated, int sumTotal) {
        if (n == 0) {
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);
        }

        int include = findMinDifference(arr, n - 1, sumCalculated + arr.get(n - 1), sumTotal);
        int exclude = findMinDifference(arr, n - 1, sumCalculated, sumTotal);

        return Math.min(include, exclude);
    }

    static int minDifference(ArrayList<Integer> arr) {
        int sumTotal = 0;

        for (int num : arr) {
            sumTotal += num;
        }

        int n = arr.size();

        boolean[][] dp = new boolean[n + 1][sumTotal + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= sumTotal; sum++) {

                dp[i][sum] = dp[i - 1][sum];

                // Include the current element if sum >= arr[i-1]
                if (sum >= arr.get(i - 1)) {
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - arr.get(i - 1)];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for (int sum = 0; sum <= sumTotal / 2; sum++) {
            if (dp[n][sum]) {
                minDiff = Math.min(minDiff, Math.abs((sumTotal - sum) - sum));
            }
        }
        return minDiff;
    }
}
