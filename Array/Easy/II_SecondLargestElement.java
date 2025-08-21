package Easy;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
// https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest
public class II_SecondLargestElement
{
    public int getSecondLargest(int[] arr)
    {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int elem : arr)
        {
            map.putIfAbsent(elem, 1);
        }
        if (map.size()
                == 1)
            return -1;

        int s = 1;
        for (Map.Entry<Integer, Integer> e : map.entrySet())
        {
            if (s
                    == 2)
                return e.getKey();
            s++;
        }
        return -1;
    }
}
