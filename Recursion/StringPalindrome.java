public class StringPalindrome
{
    public static boolean palindromeString(String s,int start,int end){
        if(start >= end){
            return true;
        }
        return (s.charAt(start) == s.charAt(end)) && palindromeString(s,start+1,end-1);
    }
    public static void main(String[] args)
    {
        String input1 = "aaabbaabbaaa";
        System.out.println(palindromeString(input1,0,input1.length()-1));
        String input2 = "aaabbcabbaaa";
        System.out.println(palindromeString(input2,0,input2.length()-1));
    }
}
