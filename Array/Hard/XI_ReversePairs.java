package Hard;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reverse-pairs/description/
public class XI_ReversePairs
{
    int sum = 0;
    public void merge_sort(int[] arr, int low,int high)
    {
        if(low < high){
            int mid = low + (high-low)/2;
            merge_sort(arr,low,mid);
            merge_sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high)
    {
        int i = low;
        int ind = mid+1;
        List<Integer> temp = new ArrayList<>();
        while(low <= mid && ind <= high){
            if(arr[low] > (long) 2*arr[ind]){
                sum += (mid-low+1);
                ind++;
            }else{
                low++;
            }
        }
        low = i;
        ind = mid+1;
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
    public int reversePairs(int[] nums) {
        sum = 0;
        merge_sort(nums,0,nums.length-1);
        return sum;
    }
}
