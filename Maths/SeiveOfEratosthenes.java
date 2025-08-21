package maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeiveOfEratosthenes {
     static List<Boolean> seiveOfEratosthenes(int n){
        List<Boolean> prime = new ArrayList<>(Collections.nCopies(n+1, true));
        for(int i=2; i*i<=n; i++){
            if(prime.get(i) == true){
                for(int j=2*i; j<=n; j+=i){
                    prime.set(j, false);
                }
            }
        }
        for(int i=2; i<=n ; i++){
            if(prime.get(i)) System.out.print(i + " ");
        }
        System.out.println();
        return prime;
    }
    public static void main(String[] args) throws java.lang.Exception {
       seiveOfEratosthenes(100);
    }
}
