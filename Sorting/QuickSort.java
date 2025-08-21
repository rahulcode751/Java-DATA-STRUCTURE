import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort
{
    /// Time complexity: O(nlogn) Worst case
    public static void main(String[] args)
    {
        Integer arr[] = {
                13,
                46,
                24,
                52,
                20,
                9};
        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(arr);
        int n = arr.length;
        System.out.println("Before merge sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        quick_sort(list,0,n-1);

        System.out.println("After quick sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void quick_sort(List<Integer> arr, int low, int high)
    {
        if(low < high){
            int pivot = pivotSort(arr,low,high);
            quick_sort(arr,low,pivot-1);
            quick_sort(arr,pivot+1,high);
        }
    }
    public static int pivotSort(List<Integer> arr, int low, int high){
        int pivot  = arr.get(low);
        int i = low;
        int j = high;

        while(i < j){
            while(arr.get(i) <= pivot && i <= high-1){
                i++;
            }
            while(arr.get(j) > pivot && j >= low+1){
                j--;
            }
            if(i < j){
                int temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }
}
