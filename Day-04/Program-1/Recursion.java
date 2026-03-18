import java.util.*;
// T.C: O(n²)
// S.C: O(n²) 
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solve(str));
    }
    public static boolean solve(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int idx = s.indexOf("pqr");
        if (idx == -1) {
            return false;
        }
        return solve(s.substring(0, idx) + s.substring(idx + 3));
    }
}