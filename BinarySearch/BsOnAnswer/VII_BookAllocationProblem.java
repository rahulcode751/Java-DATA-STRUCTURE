package BsOnAnswer;

import java.util.*;

// https://www.naukri.com/code360/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries
public class VII_BookAllocationProblem
{
    public static boolean check(ArrayList<Integer> arr, int n,int m,int mid){
        long sum = 0,count = 0;
        for(int i = 0; i<n; i++){
            if(arr.get(i) > mid) return false;
            if(sum + arr.get(i) <= mid){
                sum += arr.get(i);
            }else{
                count++;
                sum = arr.get(i);
            }
        }
        if(sum != 0) count++;
        if(count > m) return true;
        return false;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m > n) return -1;
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while(low <= high){
            int mid = low + (high - low)/2;
            boolean ans = check(arr,n,m,mid);
            if(ans == true){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return (int) low;
    }
}
