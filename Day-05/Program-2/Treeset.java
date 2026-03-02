import java.util.*;
// T.C: O(n log n) 
// S.C: O(n)
public class Treeset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        for (int i : set) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}