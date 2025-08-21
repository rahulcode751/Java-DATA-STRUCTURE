package BsOn1dArray;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
class VI_FindFirstAndLastPositionOfEleminSortedArray {
    static int lowerBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static int upperBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int x = lowerBound(nums,target);
        int y = upperBound(nums,target);
        if(x != -1){
            if(nums[x] != target){
                x = -1;
                y = -1;
            }else{
                y--;
            }
        }else{
            x = -1;
            y = -1;
        }
        return new int[] {x,y};
    }
}
