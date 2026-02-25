import java.util.*;
// T.C: O(n)
// S.C: O(n)
public class Hashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean found = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > 1) {
                found = true;
                break;
            }
        }
        System.out.println(found);
    }
}
