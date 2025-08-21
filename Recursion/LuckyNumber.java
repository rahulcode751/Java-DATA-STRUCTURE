///  https://www.geeksforgeeks.org/batch/dsa-at-your-own-pace/track/DSASP-Recursion/problem/lucky-numbers2911
public class LuckyNumber
{
    public static boolean check(int n,int counter){
        if(n%counter == 0) return false;
        if(counter > n) return true;
        return check(n-n/counter,counter+1);
    }
    public static boolean isLucky(int n)
    {
        return check(n,2);
    }
}
