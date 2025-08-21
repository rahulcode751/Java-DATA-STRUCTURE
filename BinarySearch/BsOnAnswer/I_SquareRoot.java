package BsOnAnswer;

// https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root
public class I_SquareRoot
{
    boolean check(int mid, int n){
        if(mid*mid <= n) return true;
        else return false;
    }
    int floorSqrt(int n) {
        int low = 1, high = n;
        int ans1 = low;
        while(low <= high){
            int mid = low + (high - low)/2;
            boolean ans = check(mid,n);
            if(ans == true){
                ans1 = Math.max(ans1,mid);
                low = mid + 1;
            }else{
                high = mid - 1;

            }
        }
        return ans1;
    }
}
