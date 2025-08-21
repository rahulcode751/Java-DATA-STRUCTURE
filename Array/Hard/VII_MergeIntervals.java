package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/description/
public class VII_MergeIntervals
{
    public static void sortByFirstThenSecondColumn(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
    }
    public static int[][] listToArray(List<List<Integer>> list) {
        int rows = list.size();
        int[][] array = new int[rows][];

        for (int i = 0; i < rows; i++) {
            List<Integer> row = list.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j);
            }
        }
        return array;
    }
    public int[][] merge(int[][] arr) {
        sortByFirstThenSecondColumn(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int start = -1, end = -1;
        for(int i=0; i<arr.length; i++){
            if(start == -1){
                start = arr[i][0];
                end = arr[i][1];
            }else if(end >= arr[i][0]){
                end = Math.max(end,arr[i][1]);
            }else if(end < arr[i][0]){
                ans.add(Arrays.asList(start,end));
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        ans.add(Arrays.asList(start,end));
        return listToArray(ans);
    }
}
