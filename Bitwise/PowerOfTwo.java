public class PowerOfTwo
{
    // Brian Kerningam's Algorithm  TC = O(no. of set bits)
    static boolean powerOfTwo(int n){
        if(n == 0) return false;
        return ((n&(n-1)) == 0) ? true : false;
    }
    public static void main(String[] args)
    {
        System.out.println(powerOfTwo(16));
    }
}
