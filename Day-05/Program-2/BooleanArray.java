import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class BooleanArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean [] seen = new boolean[100001];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!seen[arr[i]]) {
                seen[arr[i]] = true;
                list.add(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}