import java.util.*;
// T.C: O(k log n)
// S.C: O(k) 
class BinarySerach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < n) {
            list.add(arr[i]);
            int lo = i, hi = n - 1, lastIdx = i;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (arr[mid] == arr[i]) {
                    lastIdx = mid;
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            i = lastIdx + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int val : list) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}