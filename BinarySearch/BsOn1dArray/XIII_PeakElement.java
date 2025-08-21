package BsOn1dArray;

// https://leetcode.com/problems/find-peak-element/description/
public class XIII_PeakElement
{
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        if(n == 2) return (nums[0] < nums[1])? 1:0;
        if(nums[n-1] > nums[n-2] && nums[n-1] > nums[0]) return n-1;
        int s=1,e=n-2;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(nums[mid] <= nums[mid+1]){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return 0;
    }
}
