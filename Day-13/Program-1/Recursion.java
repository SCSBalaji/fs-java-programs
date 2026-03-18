import java.util.*;
// T.C: O(n²)
// S.C: O(n) 
class Recursion {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            checkFromIndex(arr, i, 0, 0, 0);
        }
        System.out.println(max);
    }
    public static void checkFromIndex(int [] arr, int idx, int count0, int count1, int len) {
        if (idx >= arr.length) {
            if (count0 == count1 && len > 0) {
                max = Math.max(max, len);
            }
            return;
        }
        int newCount0 = count0 + (arr[idx] == 0 ? 1 : 0);
        int newCount1 = count1 + (arr[idx] == 1 ? 1 : 0);
        int newLen = len + 1;
        if (newCount0 == newCount1) {
            max = Math.max(max, newLen);
        }
        checkFromIndex(arr, idx + 1, newCount0, newCount1, newLen);
    }
}