import java.lang.*;

class CountDigits {
    public static int countDigits(int n){
        int digit = 0;
        while(n > 0){
            n/=10;
            digit++;
        }
        return digit;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    System.out.println(countDigits(1234));
	}
}
