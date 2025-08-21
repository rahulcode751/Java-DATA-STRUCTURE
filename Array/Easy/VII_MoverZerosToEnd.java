package Easy;

// https://leetcode.com/problems/move-zeroes/description/
public class VII_MoverZerosToEnd
{
    public void moveZeroes(int[] nums) {
        int ind = -1;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0 && ind == -1) continue;
            else if(nums[i] == 0){
                if(ind == -1) ind = i;
            }else{
                nums[ind] = nums[i];
                nums[i] = 0;
                ind++;
            }
        }
    }
}
