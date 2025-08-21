package Medium;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class I_LongestSubstringWithoutRepeatingCharacters
{
    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        Set<Character> st = new HashSet<>();
        int l = 0;
        for(int r=0; r<s.length(); r++){
            if(st.contains(s.charAt(r))){
                while(st.contains(s.charAt(r))){
                    st.remove(s.charAt(l));
                    l++;
                }
            }
            st.add(s.charAt(r));
            ans = Math.max(ans,r-l+1);
        }
        if(ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}
