import java.util.*;
// T.C: O(n)
// S.C: O(k) 
class SlidingWindowHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            sum += arr[i];
        }
        if (freq.size() == k) {
            max = Math.max(max, sum);
        }
        for (int i = k; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            sum += arr[i];
            int outgoing = arr[i - k];
            freq.put(outgoing, freq.get(outgoing) - 1);
            if (freq.get(outgoing) == 0) {
                freq.remove(outgoing);
            }
            sum -= outgoing;
            if (freq.size() == k) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}