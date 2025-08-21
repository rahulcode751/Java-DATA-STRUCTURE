package Medium;

import java.util.*;

// https://leetcode.com/problems/fruit-into-baskets/description/
public class III_FruitsIntoBaskets
{
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0;
        int ans = Integer.MIN_VALUE;
        for(int r = 0; r<fruits.length; r++){
            if(m.containsKey(fruits[r]) == true){
                m.put(fruits[r], m.get(fruits[r])+1);
            }else m.put(fruits[r],1);

            while(m.size() > 2){
                int val = m.get(fruits[l]);
                if(val > 1){
                    m.put(fruits[l], val-1);
                }else m.remove(fruits[l]);
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        if(ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}
