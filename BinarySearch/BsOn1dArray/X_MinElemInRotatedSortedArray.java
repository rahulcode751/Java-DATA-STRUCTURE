package BsOn1dArray;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class X_MinElemInRotatedSortedArray
{
    public int findMin(int[] a) {
        int s = 0;
        int e = a.length - 1;
        int ans = Integer.MAX_VALUE;
        while(s<=e){
            int mid = (s+e)/2;

            if(a[s] <= a[e]){
                ans = Math.min(ans,a[s]);
                break;
            }

            if(a[s]<=a[mid]){
                ans = Math.min(ans,a[s]);
                s = mid+1;
            } else {
                ans = Math.min(ans,a[mid]);
                e = mid-1;
            }

        }
        return ans;
    }
}
