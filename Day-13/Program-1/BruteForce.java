import java.util.*;
// T.C: O(n³) 
// S.C: O(1)
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count0 = 0, count1 = 0;
                for (int k = i; k <= j; k++) {
                    if (arr[k] == 0) {
                        count0++;
                    }
                    else {
                        count1++;
                    }
                }
                if (count0 == count1) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        System.out.println(max);
    }
}