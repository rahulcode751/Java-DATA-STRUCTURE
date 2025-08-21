package Easy;

// https://leetcode.com/problems/rotate-array/description/
public class V_RotateArray
{
    private static void reverse(int[] nums, int low, int high){
        while(low < high){
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k%size;
        reverse(nums,0,size-1);
        reverse(nums,0,k-1);
        reverse(nums,k,size-1);
    }
}
