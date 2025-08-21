public class CheckIfKthBitIsSetOrNot
{
    static boolean checkIfKthBitIsSetOrNot(int n,int k){
        while(k!=0){
            n>>=1;
            k--;
            System.out.println(n+ " ");
        }
        return ((n&1) == 1) ? true: false;
    }
    static boolean checkIfKthBitIsSetOrNotOptimal(int n,int k){
        return ((n&(1<<(k-1))) != 0) ? true: false;
    }
    public static void main(String[] args)
    {
        System.out.println(checkIfKthBitIsSetOrNot(10,3));
        System.out.println(checkIfKthBitIsSetOrNotOptimal(10,2));
    }
}
