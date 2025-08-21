package Hard;

// https://leetcode.com/problems/minimum-window-substring/
public class II_MinimumWindoSubstring
{
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(m > n) return "";
        int[] hash = new int[256];

        for(int i=0; i<m; i++){
            hash[t.charAt(i)] += 1;
        }
        int l = 0, r = 0, cnt = 0, minL = Integer.MAX_VALUE, minI = -1;;
        while(r < n){
            if(hash[s.charAt(r)] > 0) cnt++;
            hash[s.charAt(r)]--;

            while(cnt == m){
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) cnt--;
                if(r-l+1 < minL){
                    minL = r-l+1;
                    minI = l;
                }
                l++;
            }

            r++;
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(minI, minI + minL);
    }
}
