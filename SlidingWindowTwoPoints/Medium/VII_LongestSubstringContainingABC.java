package Medium;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class VII_LongestSubstringContainingABC
{
    public int numberOfSubstrings(String s) {
        int cnt = 0,a = -1,b = -1, c = -1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a') a = i+1;
            if(s.charAt(i) == 'b') b = i+1;
            if(s.charAt(i) == 'c') c = i+1;
            if(a != -1 && b != -1 && c != -1){
                cnt += Math.min(a,Math.min(b,c));
            }
        }
        return cnt;
    }
}
