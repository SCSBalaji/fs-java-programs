import java.util.*;
// T.C: O(n × k log k)
// S.C: O(k) 
public class BruteForceSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i <= n - k; i++) {
            int [] sub = Arrays.copyOfRange(arr, i, i + k);
            Arrays.sort(sub);
            boolean valid = true;
            int sum = sub[0];
            for (int j = 1; j < k; j++) {
                sum += sub[j];
                if (sub[j] == sub[j - 1]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}