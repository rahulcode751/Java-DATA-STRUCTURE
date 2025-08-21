import java.util.ArrayList;

public class PowerSet
{
    static ArrayList<String> ans = new ArrayList<>();

    //Function to generate power set of string.
    static void powerSetUtil(String str, ArrayList<String> v,int index,String curr)
    {
        int n = str.length();

        // base case
        if (index == n)
        {
            v.add(curr);
            return;
        }
        //Two cases for every character
        //(i) We consider the character as part of current subset.
        //(ii) We do not consider current character as part of current subset.

        //Calling the function recursively for both cases.
        powerSetUtil(str, v, index+1, curr);
        powerSetUtil(str, v, index+1, curr+str.charAt(index));
    }
    public static void main(String[] args)
    {
        String s = "cfyujht";
        ans = new ArrayList<String>();
        powerSetUtil(s, ans, 0, "");

        //returning the list.
        System.out.println(ans);
    }
}
