import java.util.*;
// T.C: O(n)
// S.C: O(n) 
class BlockSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int depth = 0;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                depth++;
            }
            else {
                depth--;
            }
            if (depth == 0) {
                sb.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        System.out.println(sb);
    }
}