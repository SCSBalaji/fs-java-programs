import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class RecursivePrinting {
    public static void printReverse(int [] arr, int idx) {
        if (idx < 0) {
            return;
        }
        System.out.print(arr[idx] + " ");
        printReverse(arr, idx - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printReverse(arr, n - 1);
    }
}