import java.util.*;
// T.C: O(n)
// S.C: O(n) 
class Hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        for (int val : set) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}