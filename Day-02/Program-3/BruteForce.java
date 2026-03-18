import java.util.*;
// T.C: O(n × k) 
// S.C: O(k)
class BruteForce {
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
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            boolean valid = true;
            for (int j = i; j < i + k; j++) {
                if (!set.add(arr[j])) {
                    valid = false;
                    break;
                }
                sum += arr[j];
            }
            if (valid) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}