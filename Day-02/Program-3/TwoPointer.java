import java.util.*;
// T.C: O(n) 
// S.C: O(k)
class TwoPointer {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);
            sum += arr[right];
            while (freq.get(arr[right]) > 1 || (right - left + 1) > k) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) {
                    freq.remove(arr[left]);
                }
                sum -= arr[left];
                left++;
            }
            if (right - left + 1 == k) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}