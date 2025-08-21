public class BubbleSort
{
    /// Every Itration max will go to end
    /// Time complexity: O(N2) Worst case
    /// Time complexity: O(N) Best case
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
        System.out.println("Before bubble sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubble_sort(arr,n);

        System.out.println("After bubble sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubble_sort(int[] arr, int n)
    {
        for(int i=n-1; i>=0; i--){
            int swaped = 0;
            for(int j=0; j<n-1; j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swaped = 1;
                }
            }
            if(swaped == 0){
                break;
            }
        }
    }
}
