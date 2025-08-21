import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class OneOddNumberInArray
{
    static int oneOddNumberInArray(List<Integer> arr){
        int xor = 0;
        for (int i=0; i<arr.size(); i++){
            xor = xor^arr.get(i);
        }
        return xor;
    }
    public static void main(String[] args)
    {
        System.out.println(oneOddNumberInArray(Arrays.asList(1,1,2,3,4,4,3,2,7)));
    }
}
