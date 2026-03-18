import java.util.*;
// T.C: O(n)
// S.C: O(n) 
class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int depth = 0;
            int start = i;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '[') {
                    depth++;
                }
                else {
                    depth--;
                }
                if (depth == 0) {
                    result.append(s.substring(start + 1, j));
                    i = j + 1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}