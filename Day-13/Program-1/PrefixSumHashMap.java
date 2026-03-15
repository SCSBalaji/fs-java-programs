import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class PrefixSumHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] == 0) ? -1 : 1;
            if (hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            }
            else {
                hm.put(sum, i);
            }
        }
        System.out.println(max);
    }
}