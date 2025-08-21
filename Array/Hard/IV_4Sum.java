package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/4sum/description/
public class IV_4Sum
{
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();

            for(int i = 0; i < nums.length; i++) {
                if(i > 0 && nums[i] == nums[i-1]) continue;

                for(int j = i+1; j < nums.length; j++) {
                    if(j > i+1 && nums[j] == nums[j-1]) continue;

                    int low = j+1, high = nums.length-1;
                    while(low < high) {
                        long sum = (long)nums[i] + nums[j] + nums[low] + nums[high];

                        if(sum == target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

                            while(low < high && nums[low] == nums[low+1]) low++;
                            while(low < high && nums[high] == nums[high-1]) high--;

                            low++;
                            high--;
                        }
                        else if(sum < target) low++;
                        else high--;
                    }
                }
            }

            return ans;
        }
    }
}
