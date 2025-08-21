package maths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
        // Function return prime factors of a number 
    static List<Integer> primeFactors(int n ){
	    List<Integer> factors = new ArrayList<>();
		if(n <= 1) return factors;

		while(n % 2 == 0)
		{
			n = n / 2;
			factors.add(2);
		}
		while(n % 3 == 0)
		{
			n = n / 3;
			factors.add(3);
		}

		for(int i=5; i*i<=n; i=i+6)
		{
			while(n % i == 0)
			{
				n = n / i;
				factors.add(i);
			}

			while(n % (i + 2) == 0)
			{
				n = n / (i + 2);
				factors.add(i+2);
			}
		}
		if(n > 3) factors.add(n);
		return factors;
    }

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("prime factor of 450:  " + primeFactors(450));
    }
}
