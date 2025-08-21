package Monotonic;

import java.util.*;

// https://leetcode.com/problems/next-greater-element-i/description/
public class I_NextGreaterElement
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=nums2.length-1; i>=0; --i){
            while(st.peek() != -1 && st.peek() <= nums2[i]){
                st.pop();
            }
            mp.put(nums2[i],st.peek());
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            if(mp.containsKey(nums1[i]) == true){
                ans[i] = mp.get(nums1[i]);
            }else ans[i] = -1;
        }
        return ans;
    }
}
