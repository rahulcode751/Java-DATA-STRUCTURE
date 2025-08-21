package maths;

public class ComputingPower {
    static Long power(Long x, Long n){
        if(n == 0) return 1L;
        Long temp = power(x,n/2);
        temp*=temp;
        if(n%2 == 0){
            return temp;
        }
        else{
            return temp*x;
        }
    }
    static Long powerIterative(Long x,Long n){
        Long res = 1L;
        while(n > 0){
            if((n&1) == 1){
                res = res*x;
            }
            x = x*x;
            n>>=1;
        }
        return res;
    }
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(" " + power(4L,3L));
        System.out.println(" " + powerIterative(4L,3L));
    }
}
