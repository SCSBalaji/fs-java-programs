import java.util.*;
// T.C: O(n²)
// S.C: O(n) 
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < list.size(); j++) {
                if (arr[i] == list.get(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
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