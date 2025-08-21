package Easy;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays
public class IX_FindUnion
{
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int flag = -1,i =0, j = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                if(flag != a[i]){
                    ans.add(a[i]);
                    flag = a[i];
                }
                i++;
            }else{
                if(flag != b[j]){
                    ans.add(b[j]);
                    flag = b[j];
                }
                j++;
            }
        }
        while(i < a.length){
            if(flag != a[i]){
                ans.add(a[i]);
                flag = a[i];
            }
            i++;
        }
        while(j < b.length){
            if(flag != b[j]){
                ans.add(b[j]);
                flag = b[j];
            }
            j++;
        }
        return ans;
    }
}
