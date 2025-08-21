package OneDDP;

import java.util.*;

// https://leetcode.com/problems/climbing-stairs/description/
public class I_ClimbingStairs
{
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<Integer>(Collections.nCopies(n+1,0));
        dp.set(0,1);
        dp.set(1,1);

        for(int i=2; i<=n; i++){
            dp.set(i,dp.get(i-1) + dp.get(i-2));
        }

        return dp.get(n);
    }
}
