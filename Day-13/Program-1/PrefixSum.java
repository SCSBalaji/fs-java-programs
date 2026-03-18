import java.util.*;
// T.C: O(n²)
// S.C: O(n) 
class PrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int [] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int max = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefix[j] == prefix[i]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        System.out.println(max);
    }
}