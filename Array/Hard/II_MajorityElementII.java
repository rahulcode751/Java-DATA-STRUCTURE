package Hard;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/description/
public class II_MajorityElementII
{
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0,elem1 = 0,count2 = 0,elem2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == elem1) count1++;
            else if(nums[i] == elem2) count2++;
            else if(count1 == 0){
                count1 = 1;
                elem1 = nums[i];
            }
            else if(count2 == 0){
                count2 = 1;
                elem2 = nums[i];
            }else{
                count1--;
                count2--;
            }
        }
        int cnt1=0;
        int cnt2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==elem1) cnt1++;
            else if(nums[i]==elem2) cnt2++;
        }
        List<Integer> s = new ArrayList<>();
        if(cnt1 > nums.length/3) s.add(elem1);
        if(cnt2 > nums.length/3) s.add(elem2);
        return s;
    }
}
