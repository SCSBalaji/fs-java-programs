import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class NewArray {
    public static void reverse(int [] arr, int [] reversed, int i) {
        if (i >= arr.length) {
            return;
        }
        reversed[arr.length - 1 - i] = arr[i];
        reverse(arr, reversed, i + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [] reversed = new int[n];
        reverse(arr, reversed, 0);
        for (int i = 0; i < reversed.length; i++) {
            System.out.print(reversed[i] + " ");
        }
    }
}