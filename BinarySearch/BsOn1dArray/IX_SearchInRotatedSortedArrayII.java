package BsOn1dArray;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class IX_SearchInRotatedSortedArrayII
{
    public boolean search(int[] a, int key) {
        int s = 0;
        int e = a.length - 1;
        while(s<=e){
            int mid = (s+e)/2;
            if(a[mid] == key){
                return true;
            }
            if (a[s] == a[mid] && a[mid] == a[e]) {
                s = s + 1;
                e = e - 1;
                continue;
            }

            if(a[s]<=a[mid]){
                if(key>=a[s] && key<a[mid]){
                    e = mid - 1;
                }else{
                    s = mid + 1;
                }
            } else {
                if(key>=a[mid] && key<=a[e]){
                    s = mid + 1;
                }else{
                    e = mid - 1;
                }
            }

        }
        return false;
    }
}
