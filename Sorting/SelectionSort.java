public class SelectionSort
{
    /// Select minimum and swap
    /// Time complexity: O(N2)
    public static void main(String[] args)
    {
        int arr[] = {
                13,
                46,
                24,
                52,
                20,
                9};
        int n = arr.length;
        System.out.println("before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        selection_sort(arr,n);

        System.out.println("After selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selection_sort(int[] arr, int n)
    {
        for(int i=0; i<n-1; i++){
            int ind = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[ind]){
                    ind = j;
                }
            }
            int temp = arr[ind];
            arr[ind] = arr[i];
            arr[i] = temp;
        }
    }
}
