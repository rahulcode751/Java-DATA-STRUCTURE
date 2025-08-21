package Easy;

// https://leetcode.com/problems/single-number/description/
public class XII_OneAndTwiceNumber
{
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int elem: nums){
            xor^=elem;
        }
        return xor;
    }
}
