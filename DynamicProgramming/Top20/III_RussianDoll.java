package Top20;

import java.util.*;

public class III_RussianDoll
{
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        return lengthOfLIS(envelopes);
    }
    public int lengthOfLIS(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        for (int[] n : nums) {
            if (res.isEmpty() || res.get(res.size() - 1) < n[1]) {
                res.add(n[1]);
            } else {
                int idx = binarySearch(res, n[1]);
                res.set(idx, n[1]);
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
