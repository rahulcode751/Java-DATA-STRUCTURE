package Monotonic;

import java.util.*;

// https://leetcode.com/problems/next-greater-element-ii/description/
public class II_NextGreaterElementII
{
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(ans, -1);

        for(int i = 2 * n - 1; i >= 0; i--) {
            int currentElement = nums[i % n];

            while(!st.isEmpty() && st.peek() <= currentElement) {
                st.pop();
            }

            if(i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(currentElement);
        }

        return ans;
    }
}
