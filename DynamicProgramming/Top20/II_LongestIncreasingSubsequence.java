package Top20;

import java.util.*;

public class II_LongestIncreasingSubsequence
{
    // Recusrion
    static int lisEndingAtIdx(int[] arr, int idx) {
        if (idx == 0)
            return 1;

        int mx = 1;
        for (int prev = 0; prev < idx; prev++)
            if (arr[prev] < arr[idx])
                mx = Math.max(mx, lisEndingAtIdx(arr, prev) + 1);
        return mx;
    }

    // DP
    public int lengthOfLIS(int[] nums) {
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
