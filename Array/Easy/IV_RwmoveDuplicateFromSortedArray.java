package Easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class IV_RwmoveDuplicateFromSortedArray
{
    class Solution {
        public int removeDuplicates(int[] nums) {
            int ind = 1;
            for(int i=1; i<nums.length; i++){
                if(nums[i] != nums[i-1]){
                    nums[ind] = nums[i];
                    ind++;
                }
            }
            return ind;
        }
    }
}
