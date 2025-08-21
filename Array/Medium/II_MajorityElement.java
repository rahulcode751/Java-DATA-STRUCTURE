package Medium;

// https://leetcode.com/problems/majority-element/description/
public class II_MajorityElement
{
    // if majority elem is definetly present
    public int majorityElement(int[] nums) {
        int count = 0,elem = 0;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                count++;
                elem = nums[i];
            }else if(count != 0 && elem == nums[i]) count++;
            else{
                count--;
            }
        }
        return elem;
    }

    // if majority elem is msy be present
    public int majorityElement2(int[] nums) {
        int count = 0,elem = 0;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                count++;
                elem = nums[i];
            }else if(count != 0 && elem == nums[i]) count++;
            else{
                count--;
            }
        }
        count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == elem) count++;
        }
        return (count > nums.length/2)? elem: -1;
    }
}
