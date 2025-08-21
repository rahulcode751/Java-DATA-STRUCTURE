package Learning;

import java.util.*;

// https://leetcode.com/problems/min-stack/description/
public class V_MinStack
{
    ArrayList<Integer> arr;
    ArrayList<Integer> mi;
    int                top;
    int                j;

    public V_MinStack() {
        arr = new ArrayList<>();
        mi = new ArrayList<>();
        top = -1;
        j = 0;
    }

    public void push(int val) {
        arr.add(val);
        top++;
        if(j == 0){
            mi.add(val);
        }else{
            mi.add(Math.min(mi.get(j- 1),val));
        }
        j++;
    }

    public void pop() {
        if(top == -1) return;
        arr.remove(top);
        top--;
        mi.remove(j-1);
        j--;
    }

    public int top() {
        if(top == -1) return -1;
        int peek = arr.get(top);
        return peek;
    }

    public int getMin() {
        if(j == 0) return -1;
        int min = mi.get(j-1);
        return min;
    }
}
