package Easy;

// https://leetcode.com/problems/missing-number/description/
public class X_MissingNumber
{
    public int missingNumber(int[] nums) {
        int sum = 0, s = nums.length;
        for(int elem: nums){
            sum+=elem;
        }
        return (s*(s+1))/2 - sum;
    }
}
