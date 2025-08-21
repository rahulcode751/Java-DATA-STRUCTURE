package DPonLIS;

import java.util.*;

// https://leetcode.com/problems/largest-divisible-subset/description/
public class III_LargestDivisibleSubset
{
    public List<Integer> largestDivisibleSubset(int[] v) {
        Arrays.sort(v);
        int n = v.length;
        Pair<Integer,Integer>[] dp = new Pair[n];
        for(int i=0; i<n; i++){
            dp[i] = new Pair(i,1);
        }
        for(int i=1; i<n; i++){
            int ans = 1,ind = i;
            for(int j=0; j<i; j++){
                if(v[i]%v[j] == 0 && dp[j].second + 1 > ans){
                    ans = dp[j].second + 1;
                    ind = j;
                }
            }
            dp[i] = new Pair(ind,ans);
        }
        int ans = 1,ind = 0;
        for(int i=1; i<n; i++){
            if(dp[i].second > ans){
                ans = dp[i].second;
                ind = i;
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (dp[ind].first != ind) {
            arr.add(v[ind]);
            ind = dp[ind].first;
        }
        arr.add(v[ind]);

        Collections.reverse(arr);
        return arr;
    }
    class Pair<K,T>{
        public K first;
        public T second;
        public Pair(K a, T b){
            first = a;
            second = b;
        }
    }
}
