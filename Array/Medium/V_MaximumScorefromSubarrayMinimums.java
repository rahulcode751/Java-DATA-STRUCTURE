package Medium;

// https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0?category&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-in-sub-arrays
public class V_MaximumScorefromSubarrayMinimums
{
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
        int ans = arr[0] + arr[1];
        for(int i=1; i<arr.length-1; i++){
            ans = Math.max(ans,arr[i]+arr[i+1]);
        }
        return ans;
    }
}
