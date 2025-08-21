import java.lang.*;

public class GCD_LCM {
    /// euclid algorithm
    static Long gcdIterative(Long a,Long b){
        while(a != b){
            if(a > b) a-=b;
            else b-=a;
        }
        return a;
    }
    static Long gcdRecusive(Long a,Long b){
        if(a == 0) return b;
        return gcdRecusive(b%a, a);
        ///  TC = log(min(a,b))
    }
    public static void main(String[] args) {
        System.out.println(gcdIterative(4L,6L));
        System.out.println(gcdRecusive(4L,8L));
    }
}
