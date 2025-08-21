public class DigitalRoots
{
    static int sumDigits(int n)
    {
        if(n/10==0) return n;
        else return n%10+sumDigits(n/10);
    }

    public static int digitalRoot(int n)
    {
        if(n/10==0) return n;
        else return digitalRoot(sumDigits(n));
    }
    public static void main(String[] args)
    {
        int n = 7676567;
        System.out.println(digitalRoot(n));
    }
}
