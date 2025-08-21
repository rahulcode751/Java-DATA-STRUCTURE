///  https://www.geeksforgeeks.org/batch/dsa-at-your-own-pace/track/DSASP-Recursion/problem/sum-of-digits-of-a-number
public class SumOfDigits
{
    public static int sumOfDigits(int n){
        if(n/10 == 0) return n;
        return n%10 + sumOfDigits(n/10);
    }
    public static void main(String[] args)
    {
        int num = 89876;
        System.out.println(sumOfDigits(num));
    }
}
