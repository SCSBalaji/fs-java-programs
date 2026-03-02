import java.util.*;
// T.C: O(n)
// S.C: O(n)
public class Hashset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        System.out.println(set.size() < arr.length);
    }
}
