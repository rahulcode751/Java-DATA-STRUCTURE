public class InsertionSort
{
    /// Every Itration values goes to its correct place
    /// Time complexity: O(N2) Worst case
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
        System.out.println("Before Insertion sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        insertion_sort(arr,n);

        System.out.println("After insertion sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertion_sort(int[] arr, int n)
    {
        for(int i=0; i<n; i++){
            int ind = i;
            while(ind>0 && arr[ind-1] > arr[ind]){
                int temp = arr[ind-1];
                arr[ind-1] = arr[ind];
                arr[ind] = temp;
                ind--;
            }
        }
    }
}
