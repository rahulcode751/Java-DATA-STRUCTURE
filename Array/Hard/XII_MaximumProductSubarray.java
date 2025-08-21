package Hard;

// https://leetcode.com/problems/maximum-product-subarray/description/
public class XII_MaximumProductSubarray
{
    public int maxProduct(int[] nums) {
        int s = 0,mx = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                if(s == 0) s = nums[i];
                else s*=nums[i];
            }else{
                s = 0;
            }
            mx = Math.max(mx,s);
        }
        s = 0;
        for(int i=nums.length-1; i>= 0; --i){
            if(nums[i] != 0){
                if(s == 0) s = nums[i];
                else s*=nums[i];
            }else{
                s = 0;
            }
            mx = Math.max(mx,s);
        }
        return mx;
    }
}
