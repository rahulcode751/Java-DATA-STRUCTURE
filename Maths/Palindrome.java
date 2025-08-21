package maths;

public class Palindrome {
    static boolean isPalindrome(int n){
        int rev = 0, num = n;
        while(n != 0){
            rev = rev*10 + n%10;
            n = n/10;
        }
        return rev == num;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}
