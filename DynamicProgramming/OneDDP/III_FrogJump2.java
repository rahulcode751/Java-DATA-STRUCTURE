package OneDDP;

import java.util.*;

public class III_FrogJump2
{
    int minCost(int[] height, int k) {
        // code here
        int n = height.length;
        List<Integer> dp = new ArrayList<Integer>(Collections.nCopies(n,0));
        dp.set(0, 0);

        for (int i = 1; i < n; i++) {
            for(int j=1; j<=k; j++){
                if (i - j >= 0){
                    int oneStep = dp.get(i - j) + Math.abs(height[i] - height[i - j]);
                    dp.set(i, Math.min(dp.get(i), oneStep));
                }else{
                    break;
                }
            }
        }

        return dp.get(n - 1);
    }
}
