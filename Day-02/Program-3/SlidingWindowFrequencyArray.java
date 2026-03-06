import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class SlidingWindowFrequencyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            maxVal = Math.max(maxVal, arr[i]);
        }
        int [] freq = new int[maxVal + 1];
        int max = 0;
        int sum = 0;
        int uniqueCount = 0;
        for (int i = 0; i < k; i++) {
            if (freq[arr[i]] == 0) {
                uniqueCount++;
            }
            freq[arr[i]]++;
            sum += arr[i];
        }
        if (uniqueCount == k) {
            max = Math.max(max, sum);
        }
        for (int i = k; i < n; i++) {
            if (freq[arr[i]] == 0) {
                uniqueCount++;
            }
            freq[arr[i]]++;
            sum += arr[i];
            freq[arr[i - k]]--;
            if (freq[arr[i - k]] == 0) {
                uniqueCount--;
            }
            sum -= arr[i - k];
            if (uniqueCount == k) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}