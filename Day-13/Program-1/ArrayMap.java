import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class ArrayMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [] first = new int[2 * n + 1];
        Arrays.fill(first, Integer.MIN_VALUE);
        first[n] = -1;
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] == 0) ? -1 : 1;
            int idx = sum + n;
            if (first[idx] != Integer.MIN_VALUE) {
                max = Math.max(max, i - first[idx]);
            }
            else {
                first[idx] = i;
            }
        }
        System.out.println(max);
    }
}