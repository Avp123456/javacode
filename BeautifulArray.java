import java.util.*;

public class BeautifulArray {
    // Function to count the number of swaps required to sort the array
    static int countSwaps(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        boolean swapped;
        
        // Bubble sort to count swaps
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap the adjacent elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swapCount++;
                }
            }
            if (!swapped) break; // If no elements were swapped, break early
        }
        return swapCount;
    }

    // Function to count swaps required for descending order
    static int countSwapsDescending(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        boolean swapped;
        
        // Bubble sort in reverse order to count swaps for descending sort
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap the adjacent elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swapCount++;
                }
            }
            if (!swapped) break; // If no elements were swapped, break early
        }
        return swapCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of elements in the array
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        // Input the elements of the array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Copy the array to preserve original array for comparison
        int[] arrCopy = arr.clone();
        
        // Count the swaps for ascending order
        int swapsAsc = countSwaps(arr);
        
        // Count the swaps for descending order
        int swapsDesc = countSwapsDescending(arrCopy);
        
        // Output the minimum swaps required to make the array beautiful
        System.out.println(Math.min(swapsAsc, swapsDesc));
        
        sc.close();
    }
}
