import java.util.Arrays;
import java.util.List;

public class TwoOddNumberInArray
{
    static void twoOddNumberInArray(List<Integer> arr){
        int xor = 0;
        for (int i=0; i<arr.size(); i++){
            xor = xor^arr.get(i);
        }
        xor = xor & (~(xor-1));
        int first = 0, second = 0;
        for(int i=0; i<arr.size(); i++){
            if((xor & (arr.get(i))) != 0) first = first^arr.get(i);
            else second = second^arr.get(i);
        }
        System.out.println("first: " + first);
        System.out.println("second: " + second);
    }
    public static void main(String[] args)
    {
        twoOddNumberInArray(Arrays.asList(1,1,2,3,4,4,3,2,7,9));
    }
}
