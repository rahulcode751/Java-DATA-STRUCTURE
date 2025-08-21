package Hard;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array
public class X_CountInversions
{
    static int sum = 0;
    public static void merge_sort(int[] arr, int low,int high)
    {
        if(low < high){
            int mid = low + (high-low)/2;
            merge_sort(arr,low,mid);
            merge_sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high)
    {
        int i = low;
        int ind = mid+1;
        List<Integer> temp = new ArrayList<>();
        while(low <= mid && ind <= high){
            if(arr[low] > arr[ind]){
                temp.add(arr[ind]);
                ind++;
                sum += (mid+1-low);
            }else{
                temp.add(arr[low]);
                low++;
            }
        }
        while(low <= mid){
            temp.add(arr[low]);
            low++;
        }
        while(ind <= high){
            temp.add(arr[ind]);
            ind++;
        }
        for(int j=0; j<temp.size(); j++){
            arr[i + j] = temp.get(j);
        }
    }
    static int inversionCount(int arr[]) {
        // Your Code Here
        sum = 0;
        merge_sort(arr,0,arr.length-1);
        return sum;
    }
}
