package maths;

import java.util.ArrayList;
import java.util.List;

public class AllDivisorsOfNumber {
     static List<Integer> allDivisorsOfNumber(int n){
        List<Integer> divisors = new ArrayList<>();
        int i;
        for(i = 1; i*i<n; i++){
            if(n%i == 0) divisors.add(i);
        }
        for(; i>=1; --i){
            if(n%i == 0) divisors.add(n/i);
        }
        return divisors;
    }
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("All Divisors of 450: " + allDivisorsOfNumber(450));
    }
}
