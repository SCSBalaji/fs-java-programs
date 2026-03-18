import java.util.*;
// T.C: O(n) 
// S.C: O(n)
class Recursion {
    static String s;
    static int idx = 0;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        while (idx < s.length()) {
            solve(true);
        }
        System.out.println(result);
    }

    static void solve(boolean isOuter) {
        idx++;
        if (!isOuter) {
            result.append('[');
        }
        while (idx < s.length() && s.charAt(idx) != ']') {
            if (s.charAt(idx) == '[') {
                solve(false);
            }
        }
        if (!isOuter) {
            result.append(']');
        }
        idx++;
    }
}