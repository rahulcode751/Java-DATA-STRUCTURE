package Medium;

import java.util.*;

// https://leetcode.com/problems/longest-repeating-character-replacement/
public class IV_LongestRepeatingCharacterreplacement
{
    public int characterReplacement(String s, int k) {
        int l = 0;
        int ans = Integer.MIN_VALUE;
        Map<Character, Integer> m = new HashMap<>();
        int freq = 0;
        for(int r=0; r<s.length(); r++){
            char val = s.charAt(r);
            if(m.containsKey(val) == true){
                m.put(val,m.get(val)+1);
            }else{
                m.put(val,1);
            }
            freq = Math.max(freq, m.get(val));

            while(r-l+1 - freq > k){
                int v = m.get(s.charAt(l));
                if(v == 1) m.remove(s.charAt(l));
                else m.put(s.charAt(l),v-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        if(ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}
