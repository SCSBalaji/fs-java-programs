import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class SwapMirrorPosition {
    public static void reverse(int [] arr, int i) {
        int j = arr.length - 1 - i;
        if (i >= j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverse(arr, i + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        reverse(arr, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}