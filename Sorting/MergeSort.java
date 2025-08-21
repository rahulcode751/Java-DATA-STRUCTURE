import java.util.ArrayList;
import java.util.List;

import static java.io.ObjectInputFilter.merge;

public class MergeSort
{
    /// Time complexity: O(nlogn) Worst case
    public static void main(String[] args)
    {
        int arr[] = {
                13,
                46,
                24,
                52,
                20,
                9};
        int n = arr.length;
        System.out.println("Before merge sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        merge_sort(arr,0,n-1);

        System.out.println("After merge sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

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
}
