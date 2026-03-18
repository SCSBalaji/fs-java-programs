import java.util.*;
// T.C: O(n × k)
// S.C: O(k) 
class SlidingWindowRebuildSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < k; i++) {
            sum += arr[i];
            set.add(arr[i]);
        }
        if (set.size() == k) {
            max = Math.max(max, sum);
        }
        for (int i = 1; i <= n - k; i++) {
            sum += arr[i + k - 1] - arr[i - 1];
            set.clear();
            for (int j = i; j < i + k; j++) {
                set.add(arr[j]);
            }
            if (set.size() == k) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}