package OneDDP;

import java.util.*;

//https://www.geeksforgeeks.org/problems/geek-jump/1
public class II_FrogJump1
{
    int minCost(int[] height) {
        int n = height.length;
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n,0));
        dp.set(0, 0);

        for (int i = 1; i < n; i++) {
            int oneStep = dp.get(i - 1) + Math.abs(height[i] - height[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = dp.get(i - 2) + Math.abs(height[i] - height[i - 2]);
            }
            dp.set(i, Math.min(oneStep, twoStep));
        }

        return dp.get(n - 1);
    }
}
